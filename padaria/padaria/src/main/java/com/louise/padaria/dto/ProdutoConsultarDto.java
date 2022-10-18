package com.louise.padaria.dto;

public class ProdutoConsultarDto {
    private Integer id;
    private String nome;
    private Double preco;
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
