package com.pentazon.exceptions;

public class CheckOutExceptions extends PentazonException{
    public CheckOutExceptions(String message) {
        super(message);
    }

    public CheckOutExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckOutExceptions(Throwable cause) {
        super(cause);
    }
}
