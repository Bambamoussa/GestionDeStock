package com.bamba.gestiondestock.exception;

import lombok.Getter;

import java.util.List;

/**
 * cette exception sera lévée lorsqu'on voudra enregistrer ou modifier quelque chose dans la base
 * de donnée
 */

public class InvalidEntityException extends RuntimeException{

    @Getter
    private  ErrorCodes errorCodes;
    @Getter
    private List<String> errors;

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public InvalidEntityException(String message){
        super(message);
    }

    public  InvalidEntityException (String message , Throwable cause){
        super(message,cause);
    }

    public InvalidEntityException (String message , Throwable cause , ErrorCodes errorCodes){
        super(message,cause);
        this.errorCodes = errorCodes;
    }

    public InvalidEntityException(String message , ErrorCodes errorCodes){
        super(message);
        this.errorCodes = errorCodes;
    }

    public  InvalidEntityException(String message , ErrorCodes errorCodes , List<String> errors){
        super(message);
        this.errorCodes = errorCodes ;
        this.errors = errors ;
    }
}
