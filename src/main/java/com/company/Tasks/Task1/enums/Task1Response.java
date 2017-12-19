package com.company.Tasks.Task1.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task1Response {
    public ArrayList<Task1ActivityItem> items = new ArrayList<>();
}
