package com.blogspot.yemeninfo4it.mumsmobile_app.model;

import androidx.annotation.NonNull;

public class SalesPointModel {
    public int id;
    public String name;
    public int unused_card_count;
    public int used_card_count;

    public SalesPointModel(int id2, String name2, int used_card_count2, int unused_card_count2) {
        this.name = name2;
        this.id = id2;
        this.used_card_count = used_card_count2;
        this.unused_card_count = unused_card_count2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id2) {
        this.id = id2;
    }

    public int getUsed_card_count() {
        return this.used_card_count;
    }

    public void setUsed_card_count(int used_card_count2) {
        this.used_card_count = used_card_count2;
    }

    public int getUnused_card_count() {
        return this.unused_card_count;
    }

    public void setUnused_card_count(int unused_card_count2) {
        this.unused_card_count = unused_card_count2;
    }

    @NonNull
    public String toString() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SalesPointModel)) {
            return false;
        }
        SalesPointModel c = (SalesPointModel) obj;
        if (!c.getName().equals(this.name) || c.getId() != this.id) {
            return false;
        }
        return true;
    }
}
