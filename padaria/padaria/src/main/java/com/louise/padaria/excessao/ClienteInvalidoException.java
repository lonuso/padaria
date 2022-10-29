package com.louise.padaria.excessao;

import com.louise.padaria.excessao.dto.ErroData;

public class ClienteInvalidoException extends Exception{

    private ErroData erro;
    public ClienteInvalidoException(ErroData erro){
        super(erro.getMensagem());
        this.erro = erro;
    }
    public ClienteInvalidoException (String mensagem){
        super(mensagem);
    }
    public ErroData getErro(){
        return this.erro;
    }

}
