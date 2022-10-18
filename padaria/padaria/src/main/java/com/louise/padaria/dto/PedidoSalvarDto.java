package com.louise.padaria.dto;

public class PedidoSalvarDto {
    private Integer id;
    private Double valor;
    private int quantidade;
    private Integer idProduto;
    private Integer idFuncionario;
    private Integer idCliente;

    public Integer getId(){return this.id;}
    public Double getValor(){return this.valor;}
    public int getQuantidade(){return this.quantidade;}
    public Integer getIdProduto(){return this.idProduto;}
    public Integer getIdFuncionario(){return this.idFuncionario;}
    public Integer getIdCliente(){return this.idCliente;}

    public void setId(Integer id){this.id = id;}
    public void setValor(Double valor){this.valor = valor;}
    public void setQuantidade(int quantidade){this.quantidade = quantidade;}
    public void setIdProduto(Integer idProduto){this.idProduto = idProduto;}
    public void setIdFuncionario(Integer idFuncionario){this.idFuncionario = idFuncionario;}
    public void setIdCliente(Integer idCliente){this.idCliente = idCliente;}
}
