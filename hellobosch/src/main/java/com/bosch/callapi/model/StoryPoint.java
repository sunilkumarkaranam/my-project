package com.bosch.callapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoryPoint {
	@JsonProperty("issueKey")
	private String issueKey;
	@JsonProperty("storyPoint")
	private Integer storyPoint;

	public StoryPoint() {
	}

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

	@Override
	public String toString() {
		return "StoryPoint [issueKey=" + issueKey + ", storyPoint=" + storyPoint + "]";
	}
}
