package com.example.demo.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String msg){
        super(msg);
    }
}
