package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FuncionarioDto")
public class FuncionarioDto {
    @ApiModelProperty(value = "1", name = "id", dataType = "java.lang.Integer",notes = "Funcionario Id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "Louise",name = "nome", dataType = "java.lang.String",notes = "Funcionario Nome", example = "Louise")
    private String nome;
    @ApiModelProperty(value = "Secretaria",name = "cargo", dataType = "java.lang.String",notes = "Funcionario Cargo", example = "Secretaria")
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
