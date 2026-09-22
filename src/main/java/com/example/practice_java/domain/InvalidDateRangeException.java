package com.example.practice_java.domain;

public class InvalidDateRangeException extends RuntimeException {
    public InvalidDateRangeException() {
        super("The from date must be before or equal to the to date");
    }
}