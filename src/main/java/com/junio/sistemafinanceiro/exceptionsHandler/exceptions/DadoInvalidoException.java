package com.junio.sistemafinanceiro.exceptionsHandler.exceptions;

public class DadoInvalidoException extends RuntimeException{

    public DadoInvalidoException(Object o){
        super("Dado inválido: " + o.toString());
    }
}
