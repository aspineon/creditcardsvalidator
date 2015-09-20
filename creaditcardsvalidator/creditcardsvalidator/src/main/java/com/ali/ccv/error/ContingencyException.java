package com.ali.ccv.error;


public class ContingencyException extends Exception {

    private final String message;

    public ContingencyException(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
