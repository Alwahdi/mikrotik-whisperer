package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class UserProfile {
    public String id;
    public String profile;
    public String state;
    public String user;

    public UserProfile(String id2, String user2, String profile2, String state2) {
        this.id = id2;
        this.user = user2;
        this.profile = profile2;
        this.state = state2;
    }

    public UserProfile() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user2) {
        this.user = user2;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile2) {
        this.profile = profile2;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state2) {
        this.state = state2;
    }
}
