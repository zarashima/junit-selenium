package com.sample.todomvc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestStatus {

    @JsonProperty("testClass")
    private String testClass;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status;

    @JsonProperty("executionTime")
    private String executionTime;

    public void setTestClass(String testClass) {
        this.testClass = testClass;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

}
