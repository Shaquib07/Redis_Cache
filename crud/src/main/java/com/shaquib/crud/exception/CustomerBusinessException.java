package com.shaquib.crud.exception;

public class CustomerBusinessException extends RuntimeException{
    public CustomerBusinessException() {
        super();
    }

    public CustomerBusinessException(String message) {
        super(message);
    }

    public CustomerBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerBusinessException(Throwable cause) {
        super(cause);
    }

    protected CustomerBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
