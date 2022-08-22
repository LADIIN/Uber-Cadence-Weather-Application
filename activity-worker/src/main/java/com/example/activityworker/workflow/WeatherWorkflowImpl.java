package com.example.activityworker.workflow;

import com.example.activityworker.activity.RequestingWeatherActivity;
import com.example.activityworker.activity.SavingWeatherInfoActivity;
import com.example.activityworker.dto.WeatherInfoDto;
import com.uber.cadence.workflow.Workflow;

import java.util.Optional;

public class WeatherWorkflowImpl implements WeatherWorkflow {
    private final RequestingWeatherActivity requestingWeatherActivity;
    private final SavingWeatherInfoActivity savingWeatherInfoActivity;

    public WeatherWorkflowImpl() {
        requestingWeatherActivity = Workflow.newActivityStub(RequestingWeatherActivity.class);
        savingWeatherInfoActivity = Workflow.newActivityStub(SavingWeatherInfoActivity.class);
    }

    @Override
    public Optional<WeatherInfoDto> startWorkflow(String city) {
        Optional<WeatherInfoDto> weatherInfoDtoOptional = requestingWeatherActivity.getWeatherInfo(city);
        weatherInfoDtoOptional.ifPresent(savingWeatherInfoActivity::save);
        return weatherInfoDtoOptional;
    }
}
