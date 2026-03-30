package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class DeleteUser {
    public String download;
    public String id;
    public boolean isSelected;
    public String profilename;
    public String uname;
    public String upload;
    public String uptime;

    public DeleteUser(String id2, String uname2, String download2, String upload2, String profilename2, String uptime2, boolean isSelected2) {
        this.id = id2;
        this.uname = uname2;
        this.download = download2;
        this.upload = upload2;
        this.profilename = profilename2;
        this.uptime = uptime2;
        this.isSelected = isSelected2;
    }

    public DeleteUser() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname2) {
        this.uname = uname2;
    }

    public String getDownload() {
        return this.download;
    }

    public void setDownload(String download2) {
        this.download = download2;
    }

    public String getUpload() {
        return this.upload;
    }

    public void setUpload(String upload2) {
        this.upload = upload2;
    }

    public String getProfilename() {
        return this.profilename;
    }

    public void setProfilename(String profilename2) {
        this.profilename = profilename2;
    }

    public String getUptime() {
        return this.uptime;
    }

    public void setUptime(String status) {
        this.uptime = status;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }
}
