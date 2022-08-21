package com.example.workflowlauncher.service;

import com.example.activityworker.dto.WeatherInfoDto;
import com.example.workflowlauncher.exception.ServiceException;

public interface LauncherService {
    WeatherInfoDto getWeatherInfo(String city);
}
