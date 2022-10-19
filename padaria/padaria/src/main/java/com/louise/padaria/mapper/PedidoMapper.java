package com.louise.padaria.mapper;

import com.louise.padaria.dto.*;
import com.louise.padaria.model.Cliente;
import com.louise.padaria.model.Funcionario;
import com.louise.padaria.model.Pedido;
import com.louise.padaria.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    public PedidoDto converteModelParaDto(Pedido model){
        PedidoDto dto = new PedidoDto();
        dto.setId(model.getId());
        dto.setQuantidade(model.getQuantidade());
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setNome(model.getProduto().getNome());
        produtoDto.setId(model.getProduto().getId());
        dto.setProdutoDto(produtoDto);
        FuncionarioDto funcionarioDto = new FuncionarioDto();
        funcionarioDto.setId(model.getFuncionario().getId());
        funcionarioDto.setCargo(model.getFuncionario().getCargo());
        funcionarioDto.setNome(model.getFuncionario().getNome());
        dto.setFuncionarioDto(funcionarioDto);
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(model.getCliente().getId());
        clienteDto.setNome(model.getCliente().getNome());
        dto.setClienteDto(clienteDto);
        return dto;
    }
    public Pedido converteDtoParaModel(PedidoDto dto){
        Pedido model = new Pedido();
        model.setId(dto.getId());
        model.setQuantidade(dto.getQuantidade());
        Funcionario funcionarioModel = new Funcionario();
        funcionarioModel.setId(dto.getFuncionarioDto().getId());
        funcionarioModel.setNome(dto.getFuncionarioDto().getNome());
        funcionarioModel.setCargo(dto.getFuncionarioDto().getCargo());
        model.setFuncionario(funcionarioModel);
        Cliente clienteModel = new Cliente();
        clienteModel.setId(dto.getClienteDto().getId());
        clienteModel.setNome(dto.getClienteDto().getNome());
        model.setCliente(clienteModel);
        Produto produtoModel = new Produto();
        produtoModel.setId(dto.getProdutoDto().getId());
        produtoModel.setNome(dto.getProdutoDto().getNome());
        model.setProduto(produtoModel);
        return model;
    }
    public PedidoEditarDto converteModelParaDtoEditar(Pedido model){
        PedidoEditarDto dto = new PedidoEditarDto();
        dto.setId(model.getId());
        dto.setQuantidade(model.getQuantidade());
        dto.setValor(model.getValor());
        dto.setIdFuncionario(model.getFuncionario().getId());
        dto.setIdProduto(model.getProduto().getId());
        dto.setIdCliente(model.getCliente().getId());
        return dto;
    }
    public Pedido converteDtoParaModel(PedidoEditarDto dto){
        Pedido model = new Pedido();
        model.setId(dto.getId());
        model.setQuantidade(dto.getQuantidade());
        model.setValor(dto.getValor());
        Funcionario funcionarioModel = new Funcionario();
        funcionarioModel.setId(dto.getIdFuncionario());
        model.setFuncionario(funcionarioModel);
        Produto produtoModel = new Produto();
        produtoModel.setId(dto.getIdProduto());
        model.setProduto(produtoModel);
        Cliente clienteModel = new Cliente();
        clienteModel.setId(dto.getIdCliente());
        model.setCliente(clienteModel);
        return model;
    }
    public PedidoSalvarDto converteModelParaDtoSalvar(Pedido model){
        PedidoSalvarDto dto = new PedidoSalvarDto();
        dto.setId(model.getId());
        dto.setQuantidade(model.getQuantidade());
        dto.setValor(model.getValor());
        dto.setIdFuncionario(model.getFuncionario().getId());
        dto.setIdProduto(model.getProduto().getId());
        dto.setIdCliente(model.getCliente().getId());
        return dto;
    }
    public Pedido converteDtoParaModel(PedidoSalvarDto dto){
        Pedido model = new Pedido();
        model.setId(dto.getId());
        model.setQuantidade(dto.getQuantidade());
        model.setValor(dto.getValor());
        Funcionario funcionarioModel = new Funcionario();
        funcionarioModel.setId(dto.getIdFuncionario());
        model.setFuncionario(funcionarioModel);
        Produto produtoModel = new Produto();
        produtoModel.setId(dto.getIdProduto());
        model.setProduto(produtoModel);
        Cliente clienteModel = new Cliente();
        clienteModel.setId(dto.getIdCliente());
        model.setCliente(clienteModel);
        return model;
    }
    public PedidoConsultarDto converteModelParaConsultar(Pedido model){
        PedidoConsultarDto dto = new PedidoConsultarDto();
        dto.setId(model.getId());
        dto.setQuantidade(model.getQuantidade());
        ProdutoConsultarDto produtoDto = new ProdutoConsultarDto();
        produtoDto.setNome(model.getProduto().getNome());
        produtoDto.setId(model.getProduto().getId());
        produtoDto.setPreco(model.getProduto().getPreco());
        produtoDto.setQuantidade(model.getProduto().getQuantidade());
        dto.setProdutoConsultarDto(produtoDto);
        FuncionarioConsultarDto funcionarioDto = new FuncionarioConsultarDto();
        funcionarioDto.setId(model.getFuncionario().getId());
        funcionarioDto.setCargo(model.getFuncionario().getCargo());
        funcionarioDto.setNome(model.getFuncionario().getNome());
        funcionarioDto.setCpf(model.getFuncionario().getCpf());
        funcionarioDto.setTelefone(model.getFuncionario().getTelefone());
        dto.setFuncionarioConsultarDto(funcionarioDto);
        ClienteConsultarDto clienteDto = new ClienteConsultarDto();
        clienteDto.setId(model.getCliente().getId());
        clienteDto.setNome(model.getCliente().getNome());
        clienteDto.setCpf(model.getCliente().getCpf());
        clienteDto.setTelefone(model.getCliente().getTelefone());
        clienteDto.setEmail(model.getCliente().getEmail());
        clienteDto.setData(model.getCliente().getData());
        dto.setClienteConsultarDto(clienteDto);
        return dto;
    }
    public Pedido converteDtoParaConsultar(PedidoConsultarDto dto){
        Pedido model = new Pedido();
        model.setId(dto.getId());
        model.setQuantidade(dto.getQuantidade());
        Funcionario funcionarioModel = new Funcionario();
        funcionarioModel.setId(dto.getFuncionarioConsultarDto().getId());
        funcionarioModel.setNome(dto.getFuncionarioConsultarDto().getNome());
        funcionarioModel.setCargo(dto.getFuncionarioConsultarDto().getCargo());
        funcionarioModel.setCpf(dto.getClienteConsultarDto().getCpf());
        funcionarioModel.setTelefone(dto.getClienteConsultarDto().getTelefone());
        model.setFuncionario(funcionarioModel);
        Cliente clienteModel = new Cliente();
        clienteModel.setId(dto.getClienteConsultarDto().getId());
        clienteModel.setNome(dto.getClienteConsultarDto().getNome());
        clienteModel.setCpf(dto.getClienteConsultarDto().getCpf());
        clienteModel.setTelefone(dto.getClienteConsultarDto().getTelefone());
        clienteModel.setEmail(dto.getClienteConsultarDto().getEmail());
        clienteModel.setData(dto.getClienteConsultarDto().getData());
        model.setCliente(clienteModel);
        Produto produtoModel = new Produto();
        produtoModel.setId(dto.getProdutoConsultarDto().getId());
        produtoModel.setNome(dto.getProdutoConsultarDto().getNome());
        produtoModel.setPreco(dto.getProdutoConsultarDto().getPreco());
        produtoModel.setQuantidade(dto.getProdutoConsultarDto().getQuantidade());
        model.setProduto(produtoModel);
        return model;
    }
}
