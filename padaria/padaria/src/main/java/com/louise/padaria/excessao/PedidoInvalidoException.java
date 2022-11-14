package com.louise.padaria.excessao;

import com.louise.padaria.excessao.dto.ErroData;

public class PedidoInvalidoException extends Exception{
    private ErroData erro;
    public PedidoInvalidoException(ErroData erro){
        super(erro.getMensagem());
        this.erro = erro;
    }
    public PedidoInvalidoException(String mensagem){
        super(mensagem);
    }
    public ErroData getErro(){
        return this.erro;
    }
}
