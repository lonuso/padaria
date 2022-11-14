package com.louise.padaria.excessao;

public class CpfInvalidoException extends Exception {
    public CpfInvalidoException(String mensagem){
        super(mensagem);
    }
}
