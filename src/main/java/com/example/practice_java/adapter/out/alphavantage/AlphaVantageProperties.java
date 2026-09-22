package com.example.practice_java.adapter.out.alphavantage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "alphavantage")
public record AlphaVantageProperties(String baseUrl, String apiKey) {
}