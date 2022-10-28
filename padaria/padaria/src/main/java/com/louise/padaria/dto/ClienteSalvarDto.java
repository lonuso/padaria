package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "ClienteSalvarDto")
public class ClienteSalvarDto {
    @ApiModelProperty(value = "Louise",name = "nome", dataType = "java.lang.String",notes = "Cliente Nome", example = "Louise")
    private String nome;
    @ApiModelProperty(value = "156.556.456-56",name = "cpf", dataType = "java.lang.String",notes = "Cliente Cpf", example = "156.556.456-56")
    private String cpf;
    @ApiModelProperty(value = "email@email.com",name = "email", dataType = "java.lang.String",notes = "Cliente Email", example = "email@email.com")
    private String email;
    @ApiModelProperty(value = "2000-02-02",name = "data", dataType = "java.util.Date",notes = "Cliente Data", example = "20/02/1996")
    private Date data;
    @ApiModelProperty(value = "98985897336",name = "telefone",dataType = "java.lang.String",notes = "Cliente Telefone", example = "98985897336")
    private String telefone;
    public String getNome() {return nome;}
    public String getCpf() {return cpf;}
    public String getEmail() {return email;}
    public Date getData() {return data;}
    public String getTelefone() {return telefone;}

    public void setNome(String nome) {this.nome = nome;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setEmail(String email) {this.email = email;}
    public void setData(Date data) {this.data = data;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
