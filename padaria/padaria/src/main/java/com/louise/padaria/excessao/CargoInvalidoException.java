package com.louise.padaria.excessao;

public class CargoInvalidoException extends Exception{
    public CargoInvalidoException(String mensagem){
        super(mensagem);
    }
}
