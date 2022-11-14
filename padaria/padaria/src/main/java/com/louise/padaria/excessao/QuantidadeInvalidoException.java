package com.louise.padaria.excessao;

import com.louise.padaria.excessao.dto.ErroData;

public class QuantidadeInvalidoException extends Exception{

    private ErroData erro;

    public QuantidadeInvalidoException (ErroData erro){
        super(erro.getMensagem());
        this.erro = erro;
    }

    public QuantidadeInvalidoException(String mensagem){
        super(mensagem);
    }
    public ErroData getErro() {
        return this.erro;
    }
}
