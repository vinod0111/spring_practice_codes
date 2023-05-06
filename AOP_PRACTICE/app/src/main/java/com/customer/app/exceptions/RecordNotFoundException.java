package com.customer.app.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public static final long serialVersionUid = 1L;
    public RecordNotFoundException(String message) {
        super(message);
    }
}
