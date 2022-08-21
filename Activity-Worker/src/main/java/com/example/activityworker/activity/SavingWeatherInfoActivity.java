package com.example.activityworker.activity;

import com.example.activityworker.dto.WeatherInfoDto;
import com.uber.cadence.activity.ActivityMethod;

public interface SavingWeatherInfoActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 60, taskList = "taskList")
    void save(WeatherInfoDto weatherInfoDto);
}
