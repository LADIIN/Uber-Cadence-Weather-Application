package com.example.activityworker.service.impl;

import com.example.activityworker.dto.WeatherInfoDto;
import com.example.activityworker.mapper.WeatherInfoDtoMapper;
import com.example.activityworker.model.WeatherInfo;
import com.example.activityworker.repository.WeatherInfoRepository;
import com.example.activityworker.service.SavingWeatherInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavingWeatherInfoServiceImpl implements SavingWeatherInfoService {
    private final WeatherInfoRepository weatherInfoRepository;
    private final WeatherInfoDtoMapper mapper;

    @Override
    public void save(WeatherInfoDto weatherInfoDto) {
        WeatherInfo weatherInfo = mapper.map(weatherInfoDto);
        weatherInfoRepository.save(weatherInfo);
    }
}
