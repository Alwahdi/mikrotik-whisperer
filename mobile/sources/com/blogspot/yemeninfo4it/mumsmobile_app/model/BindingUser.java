package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class BindingUser {
    public String address;
    public String id;
    public String mac_address;
    public String server;
    public String type;

    public BindingUser(String id2, String mac_address2, String address2, String server2, String type2) {
        this.id = id2;
        this.mac_address = mac_address2;
        this.address = address2;
        this.type = type2;
        this.server = server2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getMac_address() {
        return this.mac_address;
    }

    public void setMac_address(String mac_address2) {
        this.mac_address = mac_address2;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address2) {
        this.address = address2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String server2) {
        this.server = server2;
    }
}
