package com.example.activityworker.mapper;

import com.example.activityworker.dto.WeatherInfoDto;
import com.example.activityworker.model.WeatherInfo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WeatherInfoDtoMapper {
    private final ModelMapper modelMapper;

    public WeatherInfo map(WeatherInfoDto weatherInfoDto) {
        return modelMapper.map(weatherInfoDto, WeatherInfo.class);
    }
}
