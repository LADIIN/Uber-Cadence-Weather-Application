package com.example.workflowlauncher.controller;

import com.example.activityworker.dto.WeatherInfoDto;
import com.example.workflowlauncher.exception.ServiceException;
import com.example.workflowlauncher.service.LauncherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/launcher")
public class LauncherController {
    private final LauncherService launcherService;

    @Autowired
    public LauncherController(LauncherService launcherService) {
        this.launcherService = launcherService;
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> handleException(ServiceException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @PostMapping("/weather")
    ResponseEntity<WeatherInfoDto> getWeatherInfo(@RequestParam String city) {
        WeatherInfoDto weatherInfoDto = launcherService.getWeatherInfo(city);
        return ResponseEntity.ok(weatherInfoDto);
    }

}
