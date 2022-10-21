package com.louise.padaria.dto;

public class PedidoDto {
    private Integer id;
    private int quantidade;
    private Double valor;
    private ProdutoDto produtoDto;
    private ClienteDto clienteDto;
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
