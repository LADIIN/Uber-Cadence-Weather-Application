package com.example.activityworker.dto;

import lombok.Value;

import java.time.LocalTime;

@Value
public class WeatherInfoDto {
    String city;
    double airTemperature;
    LocalTime recordTime;
}
