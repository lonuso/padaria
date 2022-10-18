package com.louise.padaria.dto;

public class ClienteDto {
    private Integer id;
    private String nome;

    public Integer getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
