package com.example.activityworker.activity;

import com.example.activityworker.dto.WeatherInfoDto;
import com.uber.cadence.activity.ActivityMethod;

import java.util.Optional;

public interface RequestingWeatherActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 60, taskList = "taskList")
    Optional<WeatherInfoDto> getWeatherInfo(String city);
}
