package com.manhlam.exceptions;

public class NotFoundExeption extends RuntimeException {
    public  NotFoundExeption(){}
    public NotFoundExeption(Throwable cause) {
        super(cause);
    }
    public NotFoundExeption(String msg) {
        super(msg);
    }
}
