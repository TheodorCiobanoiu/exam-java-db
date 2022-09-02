package com.tcv.exam.exception;

public class NoClientException extends Exception{
    public NoClientException(){
        super("This client does not exist!");
    }
}
