package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class HotspotCard {
    public boolean Disabled;
    public String comment;
    public String download_used;
    public String email;
    public String id;
    public boolean isSelected;
    public String limitBytesTotal;
    public String limitUptime;
    public String password;
    public String profilename;
    int sls_point_id;
    public String status;
    public String uname;
    public String upload_used;
    public String uptime_used;

    public HotspotCard(String id2, String uname2, String password2, String profilename2, String uptime_used2, String limitUptime2, String download_used2, String upload_used2, String limitBytesTotal2, String status2, boolean isSelected2, String comment2, String email2, boolean Disabled2) {
        this.id = id2;
        this.uname = uname2;
        this.password = password2;
        this.profilename = profilename2;
        this.uptime_used = uptime_used2;
        this.limitUptime = limitUptime2;
        this.upload_used = upload_used2;
        this.limitBytesTotal = limitBytesTotal2;
        this.download_used = download_used2;
        this.status = status2;
        this.isSelected = isSelected2;
        this.comment = comment2;
        this.email = email2;
        this.Disabled = Disabled2;
    }

    public HotspotCard(String id2, String uname2, String password2, String profilename2, String uptime_used2, String limitUptime2, String download_used2, String upload_used2, String limitBytesTotal2, String status2, boolean isSelected2, String comment2, String email2, boolean Disabled2, int sls_point_id2) {
        this.id = id2;
        this.uname = uname2;
        this.password = password2;
        this.profilename = profilename2;
        this.uptime_used = uptime_used2;
        this.limitUptime = limitUptime2;
        this.upload_used = upload_used2;
        this.limitBytesTotal = limitBytesTotal2;
        this.download_used = download_used2;
        this.status = status2;
        this.isSelected = isSelected2;
        this.comment = comment2;
        this.email = email2;
        this.Disabled = Disabled2;
        this.sls_point_id = sls_point_id2;
    }

    public HotspotCard() {
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

    public String getUptime_used() {
        return this.uptime_used;
    }

    public void setUptime_used(String uptime_used2) {
        this.uptime_used = uptime_used2;
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

    public String getLimitUptime() {
        return this.limitUptime;
    }

    public void setLimitUptime(String limitUptime2) {
        this.limitUptime = limitUptime2;
    }

    public String getLimitBytesTotal() {
        return this.limitBytesTotal;
    }

    public void setLimitBytesTotal(String limitBytesTotal2) {
        this.limitBytesTotal = limitBytesTotal2;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment2) {
        this.comment = comment2;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email2) {
        this.email = email2;
    }

    public boolean getDisabled() {
        return this.Disabled;
    }

    public void setDisabled(boolean disabled) {
        this.Disabled = disabled;
    }
}
