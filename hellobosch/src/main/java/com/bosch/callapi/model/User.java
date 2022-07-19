package com.bosch.callapi.model;

public class User {

    private String displayName;
    private String emailAddress;

    public User(String displayName, String emailAddress, Integer total_issue) {
        this.displayName = displayName;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return displayName;
    }

    public void setName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
