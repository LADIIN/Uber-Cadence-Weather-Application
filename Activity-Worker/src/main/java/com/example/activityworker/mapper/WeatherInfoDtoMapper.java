package com.example.activityworker.mapper;

import com.example.activityworker.dto.WeatherInfoDto;
import com.example.activityworker.model.WeatherInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherInfoDtoMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public WeatherInfoDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public WeatherInfo map(WeatherInfoDto weatherInfoDto) {
        return modelMapper.map(weatherInfoDto, WeatherInfo.class);
    }
}
