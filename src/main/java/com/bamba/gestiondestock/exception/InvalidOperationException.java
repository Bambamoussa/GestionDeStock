package com.bamba.gestiondestock.exception;

import lombok.Getter;

public class InvalidOperationException extends RuntimeException {
    

    @Getter
    private ErrorCodes errorCodes;

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }

    public  InvalidOperationException(String message){
        super(message);
    }

    public  InvalidOperationException(String message , Throwable cause){
        super(message,cause);
    }

    public InvalidOperationException(String message , Throwable cause , ErrorCodes errorCodes){
        super(message,cause);
        this.errorCodes = errorCodes;
    }

    public InvalidOperationException(String message , ErrorCodes errorCodes){
        super(message);
        this.errorCodes = errorCodes;
    }
}
