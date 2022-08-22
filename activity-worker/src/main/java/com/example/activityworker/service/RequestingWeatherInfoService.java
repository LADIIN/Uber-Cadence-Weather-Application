package com.example.activityworker.service;

import com.example.activityworker.dto.WeatherInfoDto;

import java.util.Optional;

public interface RequestingWeatherInfoService {
    Optional<WeatherInfoDto> getWeatherInfo(String city);
}
