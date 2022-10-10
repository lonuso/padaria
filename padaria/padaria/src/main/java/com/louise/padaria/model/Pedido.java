package com.louise.padaria.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_pedido")
    private Integer id;
    @Column(name = "quantidade_pedido")
    private int quantidade;
    @Column(name = "valor_pedido")
    private double valor;

    @ManyToOne
    @JoinColumn(name = "funcionario_pedido", nullable = false)
    private Funcionario funcionario;
    @ManyToOne
    @JoinColumn(name = "produto_pedido", nullable = false)
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "cliente_pedido", nullable = false)
    private Cliente cliente;

    public Integer getId(){return this.id;}
    public int getQuantidade(){return this.quantidade;}
    public double getValor(){return this.valor;}

    public void setId(Integer id){this.id = id;}
    public void setQuantidade(int quantidade){this.quantidade = quantidade;}
    public void setValor(double valor){this.valor = valor;}

    public Funcionario getFuncionario(){return this.funcionario;}
    public Produto getProduto(){return this.produto;}
    public Cliente getCliente(){return this.cliente;}
    public void setFuncionario(Funcionario funcionario){this.funcionario = funcionario;}
    public void setProduto(Produto produto){this.produto = produto;}
    public void setCliente(Cliente cliente){this.cliente = cliente;}

    @Override
    public boolean equals(Object o){
        if(this ==o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Pedido that = (Pedido) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {return id.hashCode();}
}
