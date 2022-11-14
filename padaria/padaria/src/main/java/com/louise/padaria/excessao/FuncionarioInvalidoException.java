package com.louise.padaria.excessao;

import com.louise.padaria.excessao.dto.ErroData;

public class FuncionarioInvalidoException extends Exception{
    private ErroData erro;
    public FuncionarioInvalidoException(ErroData erro){
        super(erro.getMensagem());
        this.erro = erro;
    }
    public FuncionarioInvalidoException (String mensagem){
        super(mensagem);
    }

    public ErroData getErro(){
        return this.erro;
    }
}
