package com.louise.padaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;
    @Column(name = "nome_produto")
    private String nome;
    @Column(name = "preco_produto")
    private Double preco;
    @Column(name = "quantidade_produto")
    private int quantidade;

   // @OneToMany(mappedBy = "produto")
    //@JsonIgnore
    //private List<Pedido> listaPedidos;

    public Integer getId() {return this.id;}
    public String getNome(){return this.nome;}
    public Double getPreco(){return this.preco;}
    public int getQuantidade(){return this.quantidade;}
    public void setId(Integer id){this.id = id;}
    public void setNome(String nome){this.nome = nome;}
    public void setPreco(Double preco){this.preco = preco;}
    public void setQuantidade(int quantidade){this.quantidade = quantidade;}


    //public List<Pedido> getPedido(){return this.listaPedidos;}
    //public void setPedido(List<Pedido> listaPedidos){this.listaPedidos = listaPedidos;}

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return  false;

        Produto that = (Produto) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {return id.hashCode(); }
}
