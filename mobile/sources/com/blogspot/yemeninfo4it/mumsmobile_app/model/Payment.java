package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class Payment {
    public String name;
    public String price;

    public Payment(String name2, String price2) {
        this.name = name2;
        this.price = price2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price2) {
        this.price = price2;
    }
}
