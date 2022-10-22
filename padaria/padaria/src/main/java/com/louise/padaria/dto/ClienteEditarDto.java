package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "ClienteEditarDto")
public class ClienteEditarDto {
    @ApiModelProperty(value = "1", name = "id", dataType = "java.lang.Integer",notes = "Cliente Id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "Louise",name = "nome", dataType = "java.lang.String",notes = "Cliente Nome", example = "Louise")
    private String nome;
    @ApiModelProperty(value = "156.556.456-56",name = "cpf", dataType = "java.lang.String",notes = "Cliente Cpf", example = "156.556.456-56")
    private String cpf;
    @ApiModelProperty(value = "(98)9999-9999",name = "telefone", dataType = "java.lang.String",notes = "Cliente Telefone", example = "(98)9999-9999")
    private String telefone;
    @ApiModelProperty(value = "email@email.com",name = "email", dataType = "java.lang.String",notes = "Cliente Email", example = "email@email.com")
    private String email;
    @ApiModelProperty(value = "20/02/1996",name = "data", dataType = "java.util.Date",notes = "Cliente Data", example = "20/02/1996")
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
