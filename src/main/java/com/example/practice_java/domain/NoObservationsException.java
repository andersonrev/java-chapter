package com.example.practice_java.domain;

public class NoObservationsException extends RuntimeException {
    public NoObservationsException() {
        super("No Treasury observations were found for the requested date range");
    }
}