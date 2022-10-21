package com.louise.padaria.dto;

public class PedidoConsultarDto {
    private Integer id;
    private int quantidade;
    private Double valor;
    private FuncionarioConsultarDto funcionarioConsultarDto;
    private ProdutoConsultarDto produtoConsultarDto;
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
