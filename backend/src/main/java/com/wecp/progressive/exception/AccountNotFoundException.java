package com.wecp.progressive.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String arg0){
        super(arg0);
    }
}