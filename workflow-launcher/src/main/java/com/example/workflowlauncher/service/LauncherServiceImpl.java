package com.example.workflowlauncher.service;

import com.example.activityworker.dto.WeatherInfoDto;
import com.example.activityworker.workflow.WeatherWorkflow;
import com.example.workflowlauncher.exception.ServiceException;
import com.uber.cadence.client.WorkflowClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LauncherServiceImpl implements LauncherService {
    private final WorkflowClient workflowClient;

    @Autowired
    public LauncherServiceImpl(WorkflowClient workflowClient) {
        this.workflowClient = workflowClient;
    }

    @Override
    public WeatherInfoDto getWeatherInfo(String city) {
        WeatherWorkflow weatherWorkflow = workflowClient.newWorkflowStub(WeatherWorkflow.class);
        return weatherWorkflow.startWorkflow(city).orElseThrow(() -> new ServiceException("Workflow work exception."));
    }
}
