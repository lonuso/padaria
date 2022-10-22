package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProdutoSalvarDto")
public class ProdutoSalvarDto {
    @ApiModelProperty(value = "Pão",name = "nome", dataType = "java.lang.String",notes = "Produto Nome", example = "Pão")
    private String nome;
    @ApiModelProperty(value = "2.00", name = "preco", dataType = "java.lang.Double",notes = "Produto valor", example = "2.00")
    private Double preco;
    @ApiModelProperty(value = "1", name = "quantidade", dataType = "java.lang.Integer",notes = "Produto quantidade", example = "1")
    private int quantidade;

    public String getNome() {return this.nome;}
    public Double getPreco() {return this.preco;}
    public int getQuantidade() {return this.quantidade;}

    public void setNome(String nome) {this.nome = nome;}
    public void setPreco(Double preco) {this.preco = preco;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade; }
}
