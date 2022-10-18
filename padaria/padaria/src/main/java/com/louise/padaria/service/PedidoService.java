package com.louise.padaria.service;

import com.louise.padaria.mapper.FuncionarioMapper;
import com.louise.padaria.model.Cliente;
import com.louise.padaria.model.Funcionario;
import com.louise.padaria.model.Pedido;
import com.louise.padaria.model.Produto;
import com.louise.padaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private FuncionarioMapper funcionarioMapper;

    public boolean salvarPedido(Pedido pedido){
        Funcionario funcionario = funcionarioMapper.converterDtoParaModel(funcionarioService.buscarFuncionarioPorId(pedido.getFuncionario().getId()));
        Cliente cliente = clienteService.buscarClientePorId(pedido.getCliente().getId());
        Produto produto = produtoService.buscarProdutoPorId(pedido.getProduto().getId());
        pedido.setFuncionario(funcionario);
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        repository.save(pedido);
        return true;
    }
    
    public boolean deletarPedido(Integer p){
        Pedido pedido = buscarPedidoPorId(p);
        if(pedido != null){
            repository.delete(pedido);
            return true;
        }
        return false;
    }

    public boolean atualizarPedido(Pedido ped){
        Pedido pedido = buscarPedidoPorId(ped.getId());
        if (pedido != null){
            Funcionario funcionario = funcionarioMapper.converterDtoParaModel(funcionarioService.buscarFuncionarioPorId(ped.getFuncionario().getId()));
            Cliente cliente = clienteService.buscarClientePorId(ped.getCliente().getId());
            Produto produto = produtoService.buscarProdutoPorId(ped.getProduto().getId());
            ped.setFuncionario(funcionario);
            ped.setCliente(cliente);
            ped.setProduto(produto);
            repository.save(ped);
            return true;
        }
        return false;
    }

    public Pedido buscarPedidoPorId(Integer id) {
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isPresent()){
            return pedido.get();
        }
        return null;

    }

    public List<Pedido> buscarTodosPedidos(){

        return repository.findAll();
    }

}
