package com.company.Tasks.Task1;

import com.company.Tasks.Task1.enums.Task1Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class task1Client {
    private static final String YOUTUBE="https://www.googleapis.com/youtube/v3/{method}";
    private static final String YOUTUBE_KEY="AIzaSyDgk1XZHWW3nlN3f1Rx9rlktusHV-nBmYk";
    static {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    private task1Client(){}
    public static HttpResponse<Task1Response> getSearching(String id){
        try {
            return Unirest.get(YOUTUBE)
                    .routeParam("method","channels")
                    .queryString("id",id)
                    .queryString("part","snippet,statistics")
                    .queryString("key",YOUTUBE_KEY)
                    .asObject(Task1Response.class);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }
}
