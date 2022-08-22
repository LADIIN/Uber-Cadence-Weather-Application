package com.example.activityworker.workflow;

import com.example.activityworker.dto.WeatherInfoDto;
import com.uber.cadence.workflow.WorkflowMethod;

import java.util.Optional;

public interface WeatherWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 20, taskList = "taskList")
    Optional<WeatherInfoDto> startWorkflow(String city);
}
