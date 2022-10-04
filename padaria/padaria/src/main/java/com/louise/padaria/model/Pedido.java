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

    public Integer getId(){return this.id;}
    public int getQuantidade(){return this.quantidade;}
    public double getValor(){return this.valor;}

    public void setId(Integer id){this.id = id;}
    public void setQuantidade(int quantidade){this.quantidade = quantidade;}
    public void setValor(double valor){this.valor = valor;}

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
