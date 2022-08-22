package com.example.workflowlauncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WorkflowLauncherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowLauncherApplication.class, args);
    }

}
