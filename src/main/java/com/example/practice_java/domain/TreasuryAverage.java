package com.example.practice_java.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TreasuryAverage(LocalDate from, LocalDate to, BigDecimal average) {
}