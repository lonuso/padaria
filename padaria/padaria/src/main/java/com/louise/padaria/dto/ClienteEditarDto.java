package com.louise.padaria.dto;

import java.util.Date;

public class ClienteEditarDto {
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Date data;

    public Integer getId() {return id;}
    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public String getTelefone() {return telefone;}
    public String getEmail() {return email;}
    public Date getData() {return data;}
    public void setId(Integer id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
    public void setEmail(String email) {this.email = email;}
    public void setData(Date data) {this.data = data;}

}
