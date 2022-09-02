package com.tcv.exam.exception;

public class NoStoreException extends Exception{
    public NoStoreException(){
        super("This store does not exist!");
    }
}
