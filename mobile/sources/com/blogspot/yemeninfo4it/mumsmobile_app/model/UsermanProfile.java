package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class UsermanProfile {
    public String id;
    public String price;
    public String uname;

    public UsermanProfile(String id2, String uname2, String price2) {
        this.id = id2;
        this.uname = uname2;
        this.price = price2;
    }

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname2) {
        this.uname = uname2;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id2) {
        this.id = id2;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price2) {
        this.price = price2;
    }
}
