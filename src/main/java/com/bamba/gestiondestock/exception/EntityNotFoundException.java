package com.bamba.gestiondestock.exception;

import lombok.Getter;

/**
 * cette exception sera lévée si on cherche quelque chose dans la base de donnée et qu on ne la trouve
 * pas
 */

public class EntityNotFoundException extends  RuntimeException{

    @Getter
    private ErrorCodes errorCodes;

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }

    public  EntityNotFoundException (String message){
        super(message);
    }

    public  EntityNotFoundException (String message , Throwable cause){
        super(message,cause);
    }

    public EntityNotFoundException (String message , Throwable cause , ErrorCodes errorCodes){
        super(message,cause);
        this.errorCodes = errorCodes;
    }

    public EntityNotFoundException(String message , ErrorCodes errorCodes){
        super(message);
        this.errorCodes = errorCodes;
    }
}
