package com.example.activityworker.config;

import com.example.activityworker.activity.RequestingWeatherActivity;
import com.example.activityworker.activity.SavingWeatherInfoActivity;
import com.example.activityworker.activity.impl.RequestingWeatherActivityImpl;
import com.example.activityworker.exception.DomainRegistrationException;
import com.uber.cadence.RegisterDomainRequest;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.IWorkflowService;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivityConfig {

    @Value("${cadence.domain")
    private String domain;

    @Value("${cadence.task-list")
    private String taskList;

    @Value("${retention.period.in.days}")
    private int retentionPeriodInDays;

    @Bean
    public CommandLineRunner commandLineRunner(RequestingWeatherActivity requestingWeatherActivity,
                                               SavingWeatherInfoActivity savingWeatherInfoActivity) {
        return args -> {
            registerDomain();
            registerActivity(domain, taskList, requestingWeatherActivity, savingWeatherInfoActivity);
        };
    }

    private void registerDomain() {
        IWorkflowService cadenceService = new WorkflowServiceTChannel(ClientOptions.defaultInstance());
        RegisterDomainRequest request = new RegisterDomainRequest();
        request.setName(domain)
                .setEmitMetric(false)
                .setWorkflowExecutionRetentionPeriodInDays(retentionPeriodInDays);
        try {
            cadenceService.RegisterDomain(request);
        } catch (TException e) {
            throw new DomainRegistrationException(e);
        }
    }

    private void registerActivity(String domain, String taskList, Object... activityInstances) {
        WorkflowClient workflowClient =
                WorkflowClient.newInstance(
                        new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                        WorkflowClientOptions
                                .newBuilder()
                                .setDomain(domain)
                                .build());
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(taskList);
        worker.registerActivitiesImplementations(activityInstances);
        factory.start();
    }

}
