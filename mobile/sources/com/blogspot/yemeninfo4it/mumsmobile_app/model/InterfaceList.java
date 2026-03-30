package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class InterfaceList {
    public String id;
    public String name;

    public InterfaceList() {
    }

    public InterfaceList(String id2, String name2) {
        this.id = id2;
        this.name = name2;
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
}
