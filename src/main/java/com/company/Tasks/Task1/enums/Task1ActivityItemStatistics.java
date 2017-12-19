package com.company.Tasks.Task1.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task1ActivityItemStatistics {
    public String subscriberCount;
    public String videoCount;
    public String viewCount;
}
