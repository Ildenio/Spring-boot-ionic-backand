package com.ildenio.curso.services.exception;

public class DataIntegrityExceptiion extends RuntimeException {
    public DataIntegrityExceptiion(String msg){
        super(msg);
    }
    public DataIntegrityExceptiion(String msg, Throwable cause){
        super(msg,cause);
    }
}
