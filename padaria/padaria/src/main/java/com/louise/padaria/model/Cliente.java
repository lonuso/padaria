package com.louise.padaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")

public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;
    @Column(name= "nome_cliente")
    private String nome;
    @Column(name = "cpf_cliente")
    private String cpf;
    @Column(name = "telefone_cliente")
    private String telefone;
    @Column(name = "email_cliente")
    private String email;
    @Column(name = "data_nascimento_cliente")
    private Date data;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Pedido> listaPedidos;


    public Integer getId(){return this.id;}
    public String getNome(){return this.nome;}
    public String getCpf(){return this.cpf;}
    public String getTelefone(){return this.telefone;}
    public String getEmail(){return this.email;}
    public Date getData(){return this.data;}

    public void setId(Integer id){this.id = id;}
    public void setNome(String nome){this.nome = nome;}
    public void setCpf(String cpf){this.cpf = cpf;}
    public void setTelefone(String telefone){this.telefone = telefone;}
    public void setEmail(String email){this.email = email;}
    public void setData(Date data){this.data = data;}

    public List<Pedido> getListaPedidos(){return this.listaPedidos;}
    public void setListaPedidos(List<Pedido> listaPedidos){this.listaPedidos = listaPedidos;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente that = (Cliente) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {return id.hashCode();}




}
