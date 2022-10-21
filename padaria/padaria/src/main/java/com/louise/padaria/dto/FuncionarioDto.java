package com.louise.padaria.dto;

public class FuncionarioDto {
    private Integer id;
    private String nome;
    private String cargo;

    public Integer getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCargo(){
        return this.cargo;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
