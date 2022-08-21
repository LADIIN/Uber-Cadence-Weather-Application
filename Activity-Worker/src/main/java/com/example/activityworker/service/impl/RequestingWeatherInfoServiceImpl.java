package com.example.activityworker.service.impl;

import com.example.activityworker.dto.WeatherInfoDto;
import com.example.activityworker.service.RequestingWeatherInfoService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestingWeatherInfoServiceImpl implements RequestingWeatherInfoService {
    @Value("${openweathermap.appid")
    private String appid;

    private final WebClient webClient;

    @Override
    public Optional<WeatherInfoDto> getWeatherInfo(String city) {
        Optional<WeatherInfoDto> optionalWeatherInfoDto = Optional.empty();
        String response = sendRequest(city);
        if (!response.isEmpty()) {
            JSONObject jsonObject = new JSONObject(response);
            double airTemperature = jsonObject.getJSONObject("main").getDouble("temp");
            WeatherInfoDto weatherInfoDto = new WeatherInfoDto(city, airTemperature, LocalTime.now());
            optionalWeatherInfoDto = Optional.of(weatherInfoDto);
        }
        return optionalWeatherInfoDto;
    }

    private String sendRequest(String city) {
        String url = createUrl(city);
        return webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private String createUrl(String city) {
        StringBuilder stringBuilder = new StringBuilder("http://api.openweathermap.org/data/2.5/weather?q=");
        return stringBuilder
                .append(city)
                .append("&appid=")
                .append(appid)
                .append("&units=metric")
                .toString();

    }

}
