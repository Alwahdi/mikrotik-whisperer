package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class UsermanagerCards {
    public boolean disabled;
    public String download_used;
    public String id;
    public boolean isSelected;
    public String last_seen;
    public String password;
    public String profilename;
    int sls_point_id;
    public String status;
    public String uname;
    public String upload_used;
    public String uptime_used;

    public UsermanagerCards(String id2, String uname2, String password2, String profilename2, String uptime_used2, String download_used2, String upload_used2, String status2, boolean isSelected2, boolean disabled2, String last_seen2, int sls_point_id2) {
        this.id = id2;
        this.uname = uname2;
        this.password = password2;
        this.profilename = profilename2;
        this.uptime_used = uptime_used2;
        this.download_used = download_used2;
        this.upload_used = upload_used2;
        this.status = status2;
        this.isSelected = isSelected2;
        this.disabled = disabled2;
        this.last_seen = last_seen2;
        this.sls_point_id = sls_point_id2;
    }

    public UsermanagerCards() {
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

    public String getUptime_used() {
        return this.uptime_used;
    }

    public void setUptime_used(String uptime_used2) {
        this.uptime_used = uptime_used2;
    }

    public String getUpload_used() {
        return this.upload_used;
    }

    public void setUpload_used(String upload_used2) {
        this.upload_used = upload_used2;
    }

    public String getDownload_used() {
        return this.download_used;
    }

    public void setDownload_used(String download_used2) {
        this.download_used = download_used2;
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

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean disabled2) {
        this.disabled = disabled2;
    }

    public String getLast_seen() {
        return this.last_seen;
    }

    public void setLast_seen(String last_seen2) {
        this.last_seen = last_seen2;
    }

    public int getSls_point_id() {
        return this.sls_point_id;
    }

    public void setSls_point_id(int sls_point_id2) {
        this.sls_point_id = sls_point_id2;
    }
}
