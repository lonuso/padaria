package com.louise.padaria.excessao.dto;

import java.util.List;

public class ErroData {
    private String mensagem;
    private List<ErroValor> listaValores;

    public String getMensagem(){
        return this.mensagem;
    }
    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
    public List<ErroValor> getListaValores(){
        return this.listaValores;
    }
    public void setListaValores(List<ErroValor> listaValores) {
        this.listaValores = listaValores;
    }
    public ErroData(){
    }
    public ErroData(String mensagem, List<ErroValor> listaValores){
        this.mensagem = mensagem;
        this.listaValores = listaValores;
    }

    @Override
    public String toString() {
        return "ErroData{" +
                "mensagem='" + mensagem + '\'' +
                ", listaValores=" + listaValores.toString() +
                '}';
    }
}
