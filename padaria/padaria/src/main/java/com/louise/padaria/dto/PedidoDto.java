package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "PedidoDto")
public class PedidoDto {
    @ApiModelProperty(value = "1", name = "id", dataType = "java.lang.Integer",notes = "Pedido Id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "1", name = "quantidade", dataType = "java.lang.Integer",notes = "Pedido quantidade", example = "1")
    private int quantidade;
    @ApiModelProperty(value = "2.00", name = "valor", dataType = "java.lang.Double",notes = "Pedido valor", example = "2.00")
    private Double valor;
    @ApiModelProperty(name = "produtoDto", dataType = "com.louise.padaria.dto.ProdutoDto",notes = "Pedido Produto")
    private ProdutoDto produtoDto;
    @ApiModelProperty(name = "clienteDto", dataType = "com.louise.padaria.dto.ClienteDto",notes = "Pedido Cliente")
    private ClienteDto clienteDto;
    @ApiModelProperty(name = "funcionarioDto", dataType = "com.louise.padaria.dto.FuncionarioDto",notes = "Pedido Funcionario")
    private FuncionarioDto funcionarioDto;

    public Integer getId(){return this.id;}
    public int getQuantidade(){return this.quantidade;}
    public Double getValor(){return this.valor;}
    public ProdutoDto getProdutoDto(){return this.produtoDto;}
    public ClienteDto getClienteDto(){return this.clienteDto;}
    public FuncionarioDto getFuncionarioDto(){return funcionarioDto;}

    public void setId(Integer id) {this.id = id;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
    public void setValor(Double valor) {this.valor = valor;}
    public void setProdutoDto(ProdutoDto produtoDto) {this.produtoDto = produtoDto;}
    public void setClienteDto(ClienteDto clienteDto) {this.clienteDto = clienteDto;}
    public void setFuncionarioDto(FuncionarioDto funcionarioDto) {this.funcionarioDto = funcionarioDto;}

}
