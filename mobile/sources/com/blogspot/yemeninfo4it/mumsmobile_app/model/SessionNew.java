package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class SessionNew {
    public String download;
    public String id;
    public String name;
    public String st_from;
    public String upload;
    public String uptime;

    public SessionNew(String id2, String name2, String st_from2, String uptime2, String download2, String upload2) {
        this.id = id2;
        this.name = name2;
        this.st_from = st_from2;
        this.uptime = uptime2;
        this.download = download2;
        this.upload = upload2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getStfrom() {
        return this.st_from;
    }

    public void setStfrom(String st_from2) {
        this.st_from = st_from2;
    }

    public String getSt_from() {
        return this.st_from;
    }

    public void setSt_from(String st_from2) {
        this.st_from = st_from2;
    }

    public String getUptime() {
        return this.uptime;
    }

    public void setUptime(String uptime2) {
        this.uptime = uptime2;
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
}
