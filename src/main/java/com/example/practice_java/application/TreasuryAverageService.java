package com.example.practice_java.application;

import com.example.practice_java.domain.TreasuryAverage;
import com.example.practice_java.domain.TreasuryAverageCalculator;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public class TreasuryAverageService {
    private final TreasuryYieldPort treasuryYieldPort;
    private final TreasuryAverageCalculator calculator;

    public TreasuryAverageService(TreasuryYieldPort treasuryYieldPort, TreasuryAverageCalculator calculator) {
        this.treasuryYieldPort = treasuryYieldPort;
        this.calculator = calculator;
    }

    public Mono<TreasuryAverage> average(LocalDate from, LocalDate to) {
        return treasuryYieldPort.findDailyYields()
                .map(observations -> calculator.calculate(from, to, observations));
    }
}