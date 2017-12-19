package com.company.Tasks.Task1.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Task1ActivityItemSnippet {
 public String title;
 public String publishedAt;
}
