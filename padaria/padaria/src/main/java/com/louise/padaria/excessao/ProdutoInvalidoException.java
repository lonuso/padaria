package com.louise.padaria.excessao;

import com.louise.padaria.excessao.dto.ErroData;

public class ProdutoInvalidoException extends Exception{
    private ErroData erro;
    public ProdutoInvalidoException(ErroData erro){
        super(erro.getMensagem());
        this.erro = erro;
    }
    public ProdutoInvalidoException(String mensagem){
        super(mensagem);
    }
    public ErroData getErro(){
        return this.erro;
    }
}
