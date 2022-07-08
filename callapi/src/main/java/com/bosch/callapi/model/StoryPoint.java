package com.bosch.callapi.model;

public class StoryPoint {
    private String issueKey;
    private Integer storyPoint;

    public StoryPoint(String issueKey, Integer storyPoint) {
        this.issueKey = issueKey;
        this.storyPoint = storyPoint;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public Integer getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(Integer storyPoint) {
        this.storyPoint = storyPoint;
    }
}
