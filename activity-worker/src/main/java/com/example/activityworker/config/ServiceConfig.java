package com.example.activityworker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ComponentScan("com.example.activityworker")
public class ServiceConfig {
    @Value("${openweather.source}")
    private String webClientSource;

    @Bean
    public WebClient webClient() {
        return WebClient.create(webClientSource);
    }
}
