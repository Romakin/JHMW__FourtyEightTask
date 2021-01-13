package com.example.task1.exception;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String s) {
        super(s);
    }
}
