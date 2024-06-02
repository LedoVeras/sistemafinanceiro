package com.ledo.sistemafinanceiro.exceptionsHandler.exceptions;

public class InvalidDataException extends RuntimeException{

    public InvalidDataException(Object o){
        super("Dado inválido: " + o.toString());
    }
}
