package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class Neighbors {
    public String etherinterface;
    public String ipaddress;
    public String mac;
    public String name;

    public Neighbors(String name2, String etherinterface2, String mac2, String ipaddress2) {
        this.name = name2;
        this.etherinterface = etherinterface2;
        this.mac = mac2;
        this.ipaddress = ipaddress2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getEtherinterface() {
        return this.etherinterface;
    }

    public void setEtherinterface(String etherinterface2) {
        this.etherinterface = etherinterface2;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String mac2) {
        this.mac = mac2;
    }

    public String getIpaddress() {
        return this.ipaddress;
    }

    public void setIpaddress(String ipaddress2) {
        this.ipaddress = ipaddress2;
    }
}
