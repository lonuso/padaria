package com.louise.padaria.service;

import com.louise.padaria.dto.PedidoConsultarDto;
import com.louise.padaria.dto.PedidoDto;
import com.louise.padaria.dto.PedidoEditarDto;
import com.louise.padaria.dto.PedidoSalvarDto;
import com.louise.padaria.mapper.ClienteMapper;
import com.louise.padaria.mapper.FuncionarioMapper;
import com.louise.padaria.mapper.PedidoMapper;
import com.louise.padaria.mapper.ProdutoMapper;
import com.louise.padaria.model.Cliente;
import com.louise.padaria.model.Funcionario;
import com.louise.padaria.model.Pedido;
import com.louise.padaria.model.Produto;
import com.louise.padaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ProdutoMapper produtoMapper;
    @Autowired
    private PedidoMapper mapper;

    public boolean salvarPedido(PedidoSalvarDto dto){
        Pedido pedido = mapper.converteDtoParaModel(dto);
        Funcionario funcionario = funcionarioMapper.converterDtoParaModel(funcionarioService.buscarFuncionarioPorId(dto.getIdFuncionario()));
        Cliente cliente = clienteMapper.converteDtoParaModel(clienteService.buscarClientePorId(dto.getIdCliente()));
        Produto produto = produtoMapper.converteDtoParaModel(produtoService.buscarProdutoPorId(dto.getIdProduto()));
        pedido.setFuncionario(funcionario);
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        repository.save(pedido);
        return true;
    }
    
    public boolean deletarPedido(Integer p){
        if(p != null){
        Pedido pedido = mapper.converteDtoParaModel(buscarPedidoPorId(p));
            if(pedido != null) {
                repository.delete(pedido);
                return true;
            }
        }
        return false;
    }

    public boolean atualizarPedido(PedidoEditarDto dto){
        if(dto != null){
            PedidoConsultarDto pedido = buscarPedidoPorId(dto.getId());
            if (pedido != null) {
                Pedido ped = mapper.converteDtoParaModel(dto);
                Funcionario funcionario = funcionarioMapper.converterDtoParaModel(funcionarioService.buscarFuncionarioPorId(ped.getFuncionario().getId()));
                Cliente cliente = clienteMapper.converteDtoParaModel(clienteService.buscarClientePorId(ped.getCliente().getId()));
                Produto produto = produtoMapper.converteDtoParaModel(produtoService.buscarProdutoPorId(ped.getProduto().getId()));
                ped.setFuncionario(funcionario);
                ped.setCliente(cliente);
                ped.setProduto(produto);
                repository.save(ped);
                return true;
            }
        }
        return false;
    }

    public PedidoConsultarDto buscarPedidoPorId(Integer id) {
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isPresent()){
            return mapper.converteModelParaDtoConsultar(pedido.get()) ;
        }
        return null;

    }

    public List<PedidoDto> buscarTodosPedidos(){
        List<PedidoDto> listaPedido = new ArrayList<>();
        List<Pedido> list = repository.findAll();
        for (Pedido p: list) {
            listaPedido.add(mapper.converteModelParaDto(p));
        }

        return listaPedido;
    }

}
