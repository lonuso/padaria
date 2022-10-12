package com.louise.padaria.service;

import com.louise.padaria.model.Cliente;
import com.louise.padaria.model.Funcionario;
import com.louise.padaria.model.Pedido;
import com.louise.padaria.model.Produto;
import com.louise.padaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;

    public boolean salvarPedido(Pedido pedido){
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(pedido.getFuncionario().getId());
        Cliente cliente = clienteService.buscarClientePorId(pedido.getCliente().getId());
        Produto produto = produtoService.buscarProdutoPorId(pedido.getProduto().getId());
        pedido.setFuncionario(funcionario);
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        repository.save(pedido);
        return true;
    }
    
    public boolean deletarPedido(Pedido p){
        Pedido pedido = buscarPedidoPorId(p.getId());
        if(pedido != null){
            repository.delete(p);
            return true;
        }
        return false;
    }

    public boolean atualizarPedido(Pedido ped){
        Pedido pedido = buscarPedidoPorId(ped.getId());
        if (pedido != null){
            repository.save(ped);
            return true;
        }
        return false;
    }

    public Pedido buscarPedidoPorId(Integer id) {
        Pedido pedido = repository.findById(id).get();
        return pedido;

    }

    public List<Pedido> buscarTodosPedidos(){

        return repository.findAll();
    }

}
