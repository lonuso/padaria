package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FuncionarioEditarDto")
public class FuncionarioEditarDto {
    @ApiModelProperty(value = "1", name = "id", dataType = "java.lang.Integer",notes = "Funcionario Id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "Louise",name = "nome", dataType = "java.lang.String",notes = "Funcionario Nome", example = "Louise")
    private String nome;
    @ApiModelProperty(value = "Secretaria",name = "cargo", dataType = "java.lang.String",notes = "Funcionario Cargo", example = "Secretaria")
    private String cargo;
    @ApiModelProperty(value = "156.556.456-56",name = "cpf", dataType = "java.lang.String",notes = "Funcionario Cpf", example = "156.556.456-56")
    private String cpf;
    @ApiModelProperty(value = "(98)9999-9999",name = "telefone", dataType = "java.lang.String",notes = "Funcionario Telefone", example = "(98)9999-9999")
    private String telefone;

    public Integer getId(){return this.id;}
    public String getNome(){return this.nome;}
    public String getCargo(){return this.cargo;}
    public String getCpf(){return this.cpf;}
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
    public void setTelefone(String telefone){this.telefone = telefone;}

}
