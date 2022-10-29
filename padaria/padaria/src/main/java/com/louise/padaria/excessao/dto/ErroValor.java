package com.louise.padaria.excessao.dto;

public class ErroValor {
    private String mensagem;
    private Object valorRecebido;

    public String getMensagem(){
        return mensagem;
    }
    public void setMensagem(String mensagem){
        this.mensagem = mensagem;
    }
    public Object getValorRecebido(){
        return valorRecebido;
    }
    public void setValorRecebido(Object valorRecebido){
        this.valorRecebido = valorRecebido;
    }
    public ErroValor(){

    }
    public ErroValor(String mensagem, Object valorRecebido){
        this.mensagem = mensagem;
        this.valorRecebido = valorRecebido;
    }

    @Override
    public String toString() {
        return "ErroValor{" +
                "mensagem='" + mensagem + '\'' +
                ", valorRecebido=" + valorRecebido +
                '}';
    }
}
