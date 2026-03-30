package com.blogspot.yemeninfo4it.mumsmobile_app.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class UserData {
    @SerializedName("devicetoken")
    public String devicetoken;
    @SerializedName("macaddress")
    public String macaddress;
    @SerializedName("password")
    public String password;
    @SerializedName("phone")
    public String phone;
    @SerializedName("startdate")
    public String startdate;
    @SerializedName("status")
    public String status;
    @SerializedName("timestamp")
    private Map<String, Object> timestamp = new HashMap();
    @SerializedName("uname")
    private String uname;

    public UserData() {
    }

    public UserData(String uname2, String password2, String phone2, String startdate2, String macaddress2, String status2, Map<String, Object> timestamp2, String devicetoken2) {
        this.uname = uname2;
        this.password = password2;
        this.phone = phone2;
        this.startdate = startdate2;
        this.macaddress = macaddress2;
        this.status = status2;
        this.timestamp = timestamp2;
        this.devicetoken = devicetoken2;
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone2) {
        this.phone = phone2;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate(String startdate2) {
        this.startdate = startdate2;
    }

    public String getMacaddress() {
        return this.macaddress;
    }

    public void setMacaddress(String macaddress2) {
        this.macaddress = macaddress2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public Map<String, Object> getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Map<String, Object> timestamp2) {
        this.timestamp = timestamp2;
    }

    public String getDevicetoken() {
        return this.devicetoken;
    }

    public void setDevicetoken(String devicetoken2) {
        this.devicetoken = devicetoken2;
    }
}
