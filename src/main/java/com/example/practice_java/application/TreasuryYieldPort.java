package com.example.practice_java.application;

import com.example.practice_java.domain.TreasuryObservation;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TreasuryYieldPort {
    Mono<List<TreasuryObservation>> findDailyYields();
}