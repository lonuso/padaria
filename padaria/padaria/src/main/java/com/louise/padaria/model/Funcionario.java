package com.louise.padaria.model;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//Entity -> anotação para identificar que essa classe é uma tabela no banco
@Entity
//Table -> anotação para identificar e renomear a identificação da tabela no banco
@Table(name = "funcionarios")
//public -> indica que é uma classe visivel pra geral vê meu projeto
//class -> indica que é uma class comum do Java
//implements -> indica que eu vou criar os metodos que estao na interface, nesse caso na Serializable
public class Funcionario implements Serializable{
    //Id -> anotação que representa o identificador da tabela
    @Id
    //GeneratedValue -> indica que o id vai ser incrementado sempre somando mais um. Ex: 1,2,3...
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Colum -> Ele nos ajuda renomear o atributo da classe para um equivalente na tabela
    @Column(name = "id_funcionario")
    //private -> determina que apenas quem ta dentro da minha classe consegui ve esse atributo
   private Integer id;
   @Column(name = "nome_funcionario")
   private String nome;
   @Column(name = "cargo_funcionario")
   private String cargo;
   @Column(name = "cpf_funcionario")
   private String cpf;
   @Column(name = "telefone_funcionario")
   private String telefone;

   //mappedBy -> faz referencia ao atributo que criei na classe pedido.
   //OneToMany -> Referencia inversa ao fk de funcionario na tabela pedido
   @OneToMany(mappedBy = "funcionario")
   private List<Pedido> listaPedidos;
   public List<Pedido> getListaPedidos(){
       return this.listaPedidos;
   }
   public void setListaPedidos(List<Pedido> listaPedidos){
       this.listaPedidos = listaPedidos;
   }

   //get -> é um padrão de criação de recuperar valores de um atributo
   public Integer getId(){return this.id;}
   //this -> significa que estou acessando o atributo name da minha propria classe
   public String getNome(){
       return this.nome;
   }
   public String getCargo(){
       return this.cargo;
   }
   public String getCpf(){
       return this.cpf;
   }
   public String getTelefone(){
       return this.telefone;
   }
   //set -> é um padrão de criaçao de metodo que sera responsavel por adicionar valores ao atributos
   public void setId(Integer id){
       this.id = id;
   }
   public void setNome(String nome){
       this.nome = nome;
   }
   public void setCargo(String cargo){
       this.cargo = cargo;
   }
   public void setCpf(String cpf){
       this.cpf = cpf;
   }
   public void setTelefone(String telefone){
       this.telefone = telefone;
   }


    //Override -> modifica o comportamento de um metodo como explicito na implementação abaixo
    @Override
    //equals -> metodo padrao da class Object que verifica se um objeto é igual a outro
    //sobreescrevi esse metodo porque eu queria que essa classe fosse identificada como igual quando os ids fossem iguais
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
