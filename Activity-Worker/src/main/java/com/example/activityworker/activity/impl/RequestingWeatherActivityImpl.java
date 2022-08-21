package com.example.activityworker.activity.impl;

import com.example.activityworker.activity.RequestingWeatherActivity;
import com.example.activityworker.dto.WeatherInfoDto;
import com.example.activityworker.service.RequestingWeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RequestingWeatherActivityImpl implements RequestingWeatherActivity {
    private final RequestingWeatherInfoService weatherInfoService;

    @Autowired
    public RequestingWeatherActivityImpl(RequestingWeatherInfoService weatherInfoService) {
        this.weatherInfoService = weatherInfoService;
    }

    @Override
    public Optional<WeatherInfoDto> getWeatherInfo(String city) {
        return weatherInfoService.getWeatherInfo(city);
    }
}
