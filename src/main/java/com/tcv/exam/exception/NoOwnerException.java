package com.tcv.exam.exception;

public class NoOwnerException extends Exception{
    public NoOwnerException(){
        super("This owner does not exist!");
    }
}
