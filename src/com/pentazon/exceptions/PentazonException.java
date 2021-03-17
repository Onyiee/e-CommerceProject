package com.pentazon.exceptions;

public class PentazonException extends Exception{

    public PentazonException(String message) {
        super(message);
    }

    public PentazonException(String message, Throwable cause) {
        super(message, cause);
    }

    public PentazonException(Throwable cause) {
        super(cause);
    }
}
