package com.example.activityworker.activity.impl;

import com.example.activityworker.activity.SavingWeatherInfoActivity;
import com.example.activityworker.dto.WeatherInfoDto;
import com.example.activityworker.service.SavingWeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavingWeatherInfoActivityImpl implements SavingWeatherInfoActivity {
    private final SavingWeatherInfoService weatherInfoService;

    @Autowired
    public SavingWeatherInfoActivityImpl(SavingWeatherInfoService weatherInfoService) {
        this.weatherInfoService = weatherInfoService;
    }

    @Override
    public void save(WeatherInfoDto weatherInfoDto) {
        weatherInfoService.save(weatherInfoDto);
    }
}
