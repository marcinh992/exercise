package com.exercise.starservice.exception;

public class StarNotFoundException extends RuntimeException {
    public StarNotFoundException(String message) {
        super(message);
    }
}
