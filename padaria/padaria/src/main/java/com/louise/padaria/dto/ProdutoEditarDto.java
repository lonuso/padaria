package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProdutoEditarDto")
public class ProdutoEditarDto {
    @ApiModelProperty(value = "1", name = "id", dataType = "java.lang.Integer",notes = "Produto Id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "Pão",name = "nome", dataType = "java.lang.String",notes = "Produto Nome", example = "Pão")
    private String nome;
    @ApiModelProperty(value = "2.00", name = "preco", dataType = "java.lang.Double",notes = "Produto valor", example = "2.00")
    private Double preco;
    @ApiModelProperty(value = "1", name = "quantidade", dataType = "java.lang.Integer",notes = "Produto quantidade", example = "1")
    private int quantidade;

    public Integer getId() {return this.id;}
    public String getNome() {return this.nome;}
    public Double getPreco() {return this.preco;}
    public int getQuantidade() {return this.quantidade;}

    public void setId(Integer id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setPreco(Double preco) {this.preco = preco;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

}
