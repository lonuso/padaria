package com.louise.padaria.dto;

public class PedidoEditarDto {
    private Integer id;
    private int quantidade;
    private Double valor;
    private Integer idFuncionario;
    private Integer idProduto;
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
