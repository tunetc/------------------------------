package com.example.Lab7.Circuit_Breaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class TimeService {

    private final RestTemplate restTemplate;
    private final String timeServiceUrl;

    public TimeService(RestTemplate restTemplate, @Value("${timeservice.url}") String timeServiceUrl) {
        this.restTemplate = restTemplate;
        this.timeServiceUrl = timeServiceUrl;
    }

    @CircuitBreaker(name = "timeService", fallbackMethod = "fallbackTime")
    public String getCurrentTime() {
        try {
            return restTemplate.getForObject(timeServiceUrl, String.class);
        } catch (HttpServerErrorException e) {
            throw new RuntimeException("Помилка сервера: " + e.getStatusCode());
        }
    }

    public String fallbackTime(Throwable t) {
        return "Час за замовчуванням";
    }
}

