package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PedidoEditarDto")
public class PedidoEditarDto {
    @ApiModelProperty(value = "1", name = "id", dataType = "java.lang.Integer",notes = "Pedido Id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "1", name = "quantidade", dataType = "java.lang.Integer",notes = "Pedido quantidade", example = "1")
    private int quantidade;
    @ApiModelProperty(value = "2.00", name = "valor", dataType = "java.lang.Double",notes = "Pedido valor", example = "2.00")
    private Double valor;
    @ApiModelProperty(value = "1", name = "idFuncionario", dataType = "java.lang.Integer",notes = "Pedido IdFuncionario", example = "1")
    private Integer idFuncionario;
    @ApiModelProperty(value = "1", name = "idProduto", dataType = "java.lang.Integer",notes = "Pedido IdProduto", example = "1")
    private Integer idProduto;
    @ApiModelProperty(value = "1", name = "idCliente", dataType = "java.lang.Integer",notes = "Pedido IdCliente", example = "1")
    private Integer idCliente;

    public Integer getId(){return this.id;}
    public int getQuantidade(){return this.quantidade;}
    public Double getValor(){return this.valor;}
    public Integer getIdFuncionario(){return this.idFuncionario;}
    public Integer getIdProduto(){return this.idProduto;}
    public Integer getIdCliente(){return idCliente;}

    public void setId(Integer id){this.id = id;}
    public void setQuantidade(int quantidade){this.quantidade = quantidade;}
    public void setValor(Double valor){this.valor = valor;}
    public void setIdFuncionario(Integer idFuncionario){this.idFuncionario = idFuncionario;}
    public void setIdProduto(Integer idProduto){this.idProduto = idProduto;}
    public void setIdCliente(Integer idCliente){this.idCliente = idCliente;}


}
