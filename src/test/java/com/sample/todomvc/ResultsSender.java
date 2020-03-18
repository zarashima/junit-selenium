package com.sample.todomvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ResultsSender {
    private static final ObjectMapper om = new ObjectMapper();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String ELASTICSEARCH_URL = "http://localhost:9200/app/suite";

    public static void sendResult(final TestStatus testStatus) {
        try {
            Unirest.post(ELASTICSEARCH_URL)
                    .header(CONTENT_TYPE,CONTENT_TYPE_VALUE)
                    .body(om.writeValueAsString(testStatus)).asJson();
        } catch (UnirestException | JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
