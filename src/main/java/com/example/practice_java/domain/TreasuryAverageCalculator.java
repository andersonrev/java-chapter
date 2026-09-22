package com.example.practice_java.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class TreasuryAverageCalculator {
    public TreasuryAverage calculate(LocalDate from, LocalDate to, List<TreasuryObservation> observations) {
        if (from.isAfter(to)) {
            throw new InvalidDateRangeException();
        }

        List<TreasuryObservation> inRange = observations.stream()
                .filter(observation -> !observation.date().isBefore(from))
                .filter(observation -> !observation.date().isAfter(to))
                .toList();

        if (inRange.isEmpty()) {
            throw new NoObservationsException();
        }

        BigDecimal sum = inRange.stream()
                .map(TreasuryObservation::yield)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new TreasuryAverage(from, to,
                sum.divide(BigDecimal.valueOf(inRange.size()), 2, RoundingMode.HALF_UP));
    }
}