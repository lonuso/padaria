package com.louise.padaria.dto;

import java.util.Date;

public class ClienteSalvarDto {
    private String nome;
    private String cpf;
    private String email;
    private Date data;

    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public String getEmail() {return email;}
    public Date getData() {return data;}

    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setEmail(String email) {this.email = email;}
    public void setData(Date data) {this.data = data;}
}
