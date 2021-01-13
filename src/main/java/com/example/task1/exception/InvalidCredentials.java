package com.example.task1.exception;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String s) {
        super(s);
    }
}
