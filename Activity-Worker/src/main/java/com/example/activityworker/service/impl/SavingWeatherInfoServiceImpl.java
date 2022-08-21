package com.example.activityworker.service.impl;

import com.example.activityworker.dto.WeatherInfoDto;
import com.example.activityworker.mapper.WeatherInfoDtoMapper;
import com.example.activityworker.model.WeatherInfo;
import com.example.activityworker.repository.WeatherInfoRepository;
import com.example.activityworker.service.SavingWeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingWeatherInfoServiceImpl implements SavingWeatherInfoService {
    private final WeatherInfoRepository weatherInfoRepository;
    private final WeatherInfoDtoMapper mapper;

    @Autowired
    public SavingWeatherInfoServiceImpl(WeatherInfoRepository weatherInfoRepository, WeatherInfoDtoMapper mapper) {
        this.weatherInfoRepository = weatherInfoRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(WeatherInfoDto weatherInfoDto) {
        WeatherInfo weatherInfo = mapper.map(weatherInfoDto);
        weatherInfoRepository.save(weatherInfo);
    }
}
