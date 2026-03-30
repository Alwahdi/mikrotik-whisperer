package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class LoginData {
    String desc;
    String ipaddress;
    String password;
    String port;
    String username;

    public LoginData(String ipaddress2, String username2, String password2, String port2, String desc2) {
        this.ipaddress = ipaddress2;
        this.username = username2;
        this.password = password2;
        this.port = port2;
        this.desc = desc2;
    }

    public String getIpaddress() {
        return this.ipaddress;
    }

    public void setIpaddress(String ipaddress2) {
        this.ipaddress = ipaddress2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username2) {
        this.username = username2;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public String getPort() {
        return this.port;
    }

    public void setPort(String port2) {
        this.port = port2;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc2) {
        this.desc = desc2;
    }
}
