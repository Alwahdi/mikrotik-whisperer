package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class AddUserHotspot {
    public boolean isSelected;
    public String password;
    public String profilename;
    public String status;
    public String uname;

    public AddUserHotspot(String uname2, String password2, String profilename2, String status2, boolean isSelected2) {
        this.uname = uname2;
        this.password = password2;
        this.profilename = profilename2;
        this.status = status2;
        this.isSelected = isSelected2;
    }

    public AddUserHotspot() {
    }

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname2) {
        this.uname = uname2;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public String getProfilename() {
        return this.profilename;
    }

    public void setProfilename(String profilename2) {
        this.profilename = profilename2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }
}
