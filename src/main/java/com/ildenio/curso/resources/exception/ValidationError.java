package com.ildenio.curso.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private List<FieldMessage> Errors = new ArrayList<>();

    public ValidationError(Integer id, String msg, Long timeStanp) {
        super(id, msg, timeStanp);
    }

    public List<FieldMessage> getErrors() {
        return Errors;
    }

    public void addError(String fieldName,String messagem) {
        Errors.add(new FieldMessage(fieldName,messagem));
    }
}
