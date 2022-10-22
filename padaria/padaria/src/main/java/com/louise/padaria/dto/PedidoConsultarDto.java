package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "PedidoConsultarDto")
public class PedidoConsultarDto {
    @ApiModelProperty(value = "1", name = "id", dataType = "java.lang.Integer",notes = "Pedido Id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "1", name = "quantidade", dataType = "java.lang.Integer",notes = "Pedido quantidade", example = "1")
    private int quantidade;
    @ApiModelProperty(value = "2.00", name = "valor", dataType = "java.lang.Double",notes = "Pedido valor", example = "2.00")
    private Double valor;
    @ApiModelProperty(name = "funcionarioConsultaDto", dataType = "com.louise.padaria.dto.FuncionarioConsultaDto",notes = "Pedido Funcionario")
    private FuncionarioConsultarDto funcionarioConsultarDto;
    @ApiModelProperty(name = "produtoConsultarDto", dataType = "com.louise.padaria.dto.ProdutoConsultaDto",notes = "Pedido Produto")
    private ProdutoConsultarDto produtoConsultarDto;
    @ApiModelProperty(name = "clienteConsultarDto", dataType = "com.louise.padaria.dto.ClienteConsultaDto",notes = "Pedido Cliente")
    private ClienteConsultarDto clienteConsultarDto;

    public Integer getId(){return this.id;}
    public int getQuantidade(){return this.quantidade;}
    public Double getValor(){return this.valor;}
    public FuncionarioConsultarDto getFuncionarioConsultarDto(){return this.funcionarioConsultarDto;}
    public ProdutoConsultarDto getProdutoConsultarDto(){return this.produtoConsultarDto;}
    public ClienteConsultarDto getClienteConsultarDto(){return this.clienteConsultarDto;}

    public void setId(Integer id){this.id = id;}
    public void setQuantidade(int quantidade){this.quantidade = quantidade;}
    public void setValor(Double valor) {this.valor = valor;}
    public void setFuncionarioConsultarDto(FuncionarioConsultarDto funcionarioConsultarDto) {this.funcionarioConsultarDto = funcionarioConsultarDto;}
    public void setProdutoConsultarDto(ProdutoConsultarDto produtoConsultarDto) {this.produtoConsultarDto = produtoConsultarDto;}
    public void setClienteConsultarDto(ClienteConsultarDto clienteConsultarDto) {this.clienteConsultarDto = clienteConsultarDto;}
}
