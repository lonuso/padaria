package com.louise.padaria.excessao;

public class EmailInvalidoException extends Exception{
    public EmailInvalidoException(String mensagem){
        super(mensagem);
    }
}
