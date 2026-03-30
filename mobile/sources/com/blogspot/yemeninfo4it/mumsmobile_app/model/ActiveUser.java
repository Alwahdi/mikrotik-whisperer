package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class ActiveUser {
    public String address;
    public String download;
    public String id;
    public String mac_address;
    public String name;
    public String timeleft;
    public String upload;
    public String uptime;

    public ActiveUser(String id2, String name2, String uptime2, String address2, String upload2, String download2, String timeleft2, String mac_address2) {
        this.id = id2;
        this.name = name2;
        this.uptime = uptime2;
        this.upload = upload2;
        this.download = download2;
        this.timeleft = timeleft2;
        this.address = address2;
        this.mac_address = mac_address2;
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

    public String getTimeleft() {
        return this.timeleft;
    }

    public void setTimeleft(String timeleft2) {
        this.timeleft = timeleft2;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address2) {
        this.address = address2;
    }

    public String getMac_address() {
        return this.mac_address;
    }

    public void setMac_address(String mac_address2) {
        this.mac_address = mac_address2;
    }
}
