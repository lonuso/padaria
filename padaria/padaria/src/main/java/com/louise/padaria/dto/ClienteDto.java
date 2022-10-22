package com.louise.padaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ClienteDto")
public class ClienteDto {
    @ApiModelProperty(value = "1", name = "id", dataType = "java.lang.Integer",notes = "Cliente Id", example = "1")
    private Integer id;
    @ApiModelProperty(value = "Louise",name = "nome", dataType = "java.lang.String",notes = "Cliente Nome", example = "Louise")
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
