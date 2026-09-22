package com.example.practice_java.adapter.in.web;

import com.example.practice_java.domain.InvalidDateRangeException;
import com.example.practice_java.domain.NoObservationsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class TreasuryErrorHandler {
    @ExceptionHandler(InvalidDateRangeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Map<String, String> invalidDateRange(InvalidDateRangeException exception) {
        return Map.of("error", exception.getMessage());
    }

    @ExceptionHandler(NoObservationsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Map<String, String> noObservations(NoObservationsException exception) {
        return Map.of("error", exception.getMessage());
    }
}