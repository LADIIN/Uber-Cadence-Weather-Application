package com.example.workflowworker;


import com.example.activityworker.workflow.WeatherWorkflowImpl;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Invalid application arguments: [domain name], [task-list name].");
        }
        WorkflowFactory workflowFactory = new WorkflowFactory();
        workflowFactory.start(args[0], args[1], WeatherWorkflowImpl.class);
    }
}
