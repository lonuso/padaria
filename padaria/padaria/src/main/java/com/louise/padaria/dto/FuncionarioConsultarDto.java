package com.louise.padaria.dto;

public class FuncionarioConsultarDto {
    private Integer id;
    private String nome;
    private String cargo;
    private String cpf;
    private String telefone;

    public Integer getId(){
        return this.id;
    }
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
    public void setId(Integer id){
        this. id = id;
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
}
