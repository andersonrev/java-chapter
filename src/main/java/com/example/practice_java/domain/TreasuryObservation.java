package com.example.practice_java.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TreasuryObservation(LocalDate date, BigDecimal yield) {
}