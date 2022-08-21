package com.example.workflowlauncher.service;

import com.example.activityworker.dto.WeatherInfoDto;

public interface LauncherService {
    WeatherInfoDto getWeatherInfo(String city);
}
