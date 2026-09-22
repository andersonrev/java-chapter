package com.example.practice_java.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TreasuryAverageCalculatorTest {
    private final TreasuryAverageCalculator calculator = new TreasuryAverageCalculator();

    @Test
    void calculatesAverageUsingOnlyObservationsInsideRange() {
        List<TreasuryObservation> observations = List.of(
                observation("2026-08-11", "5.00"),
                observation("2026-08-12", "5.24"),
                observation("2026-08-13", "5.21"),
                observation("2026-08-18", "5.18"),
                observation("2026-08-19", "5.50"));

        TreasuryAverage result = calculator.calculate(
                LocalDate.parse("2026-08-12"), LocalDate.parse("2026-08-18"), observations);

        assertEquals(new BigDecimal("5.21"), result.average());
    }

    @Test
    void rejectsAnInvertedDateRange() {
        assertThrows(InvalidDateRangeException.class, () -> calculator.calculate(
                LocalDate.parse("2026-08-18"), LocalDate.parse("2026-08-12"), List.of()));
    }

    @Test
    void rejectsARequestWithoutObservations() {
        assertThrows(NoObservationsException.class, () -> calculator.calculate(
                LocalDate.parse("2026-08-12"), LocalDate.parse("2026-08-18"), List.of()));
    }

    private TreasuryObservation observation(String date, String value) {
        return new TreasuryObservation(LocalDate.parse(date), new BigDecimal(value));
    }
}