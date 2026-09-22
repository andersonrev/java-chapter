package com.example.practice_java.adapter.out.alphavantage;

import com.example.practice_java.application.TreasuryYieldPort;
import com.example.practice_java.domain.TreasuryObservation;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class AlphaVantageClient implements TreasuryYieldPort {
    private final WebClient webClient;
    private final AlphaVantageProperties properties;

    public AlphaVantageClient(WebClient.Builder builder, AlphaVantageProperties properties) {
        this.webClient = builder.baseUrl(properties.baseUrl()).build();
        this.properties = properties;
    }

    @Override
    public Mono<List<TreasuryObservation>> findDailyYields() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("function", "TREASURY_YIELD")
                        .queryParam("interval", "daily")
                        .queryParam("maturity", "30year")
                        .queryParam("apikey", properties.apiKey())
                        .build())
                .retrieve()
                .bodyToMono(AlphaVantageResponse.class)
                .map(response -> response.observations().stream()
                        .filter(observation -> !".".equals(observation.value()))
                        .map(observation -> new TreasuryObservation(
                                LocalDate.parse(observation.date()),
                                new BigDecimal(observation.value())))
                        .toList());
    }

    private record AlphaVantageResponse(List<ObservationResponse> observations) {
    }

    private record ObservationResponse(String date, String value) {
    }
}