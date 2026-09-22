package com.example.practice_java.adapter.in.web;

import com.example.practice_java.application.TreasuryAverageService;
import com.example.practice_java.domain.TreasuryAverage;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/treasury/30y")
public class TreasuryController {
    private final TreasuryAverageService service;

    public TreasuryController(TreasuryAverageService service) {
        this.service = service;
    }

    @GetMapping("/average")
    public Mono<TreasuryAverage> average(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return service.average(from, to);
    }
}