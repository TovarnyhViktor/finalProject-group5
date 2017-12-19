package com.company.Tasks.Task1.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task1ActivityItem {
    public Task1ActivityItemSnippet snippet;
    public Task1ActivityItemStatistics statistics;
}
