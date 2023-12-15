package com.picpay.exceptions;

public class CpfAlreadyExists extends RuntimeException{
    public CpfAlreadyExists(String param) {
        super(param);
    }
}
