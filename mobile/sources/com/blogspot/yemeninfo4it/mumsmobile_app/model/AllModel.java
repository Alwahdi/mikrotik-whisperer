package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class AllModel {
    Integer image;
    String name;
    String time;
    String txt;

    public Integer getImage() {
        return this.image;
    }

    public void setImage(Integer image2) {
        this.image = image2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time2) {
        this.time = time2;
    }

    public String getTxt() {
        return this.txt;
    }

    public void setTxt(String txt2) {
        this.txt = txt2;
    }

    public AllModel(Integer image2, String name2, String time2, String txt2) {
        this.image = image2;
        this.name = name2;
        this.time = time2;
        this.txt = txt2;
    }
}
