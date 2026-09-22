package com.example.practice_java;

import com.example.practice_java.adapter.out.alphavantage.AlphaVantageProperties;
import com.example.practice_java.application.TreasuryAverageService;
import com.example.practice_java.application.TreasuryYieldPort;
import com.example.practice_java.domain.TreasuryAverageCalculator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AlphaVantageProperties.class)
public class PracticeJavaConfiguration {
    @Bean
    TreasuryAverageCalculator treasuryAverageCalculator() {
        return new TreasuryAverageCalculator();
    }

    @Bean
    TreasuryAverageService treasuryAverageService(TreasuryYieldPort treasuryYieldPort,
                                                   TreasuryAverageCalculator calculator) {
        return new TreasuryAverageService(treasuryYieldPort, calculator);
    }
}