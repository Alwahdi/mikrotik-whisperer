package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class ProfileModel {
    public String download_limit;
    public String id;
    public String limitation;
    public String name;
    public String owner;
    public String price;
    public String profile_limitation;
    public String time_limit;
    public String trans_limit;
    public String validty_limit;

    public ProfileModel() {
    }

    public ProfileModel(String id2, String name2, String price2, String trans_limit2, String download_limit2, String time_limit2, String validty_limit2, String limitation2, String profile_limitation2, String owner2) {
        this.id = id2;
        this.name = name2;
        this.price = price2;
        this.trans_limit = trans_limit2;
        this.download_limit = download_limit2;
        this.time_limit = time_limit2;
        this.validty_limit = validty_limit2;
        this.limitation = limitation2;
        this.profile_limitation = profile_limitation2;
        this.owner = owner2;
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

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price2) {
        this.price = price2;
    }

    public String getTrans_limit() {
        return this.trans_limit;
    }

    public void setTrans_limit(String trans_limit2) {
        this.trans_limit = trans_limit2;
    }

    public String getDownload_limit() {
        return this.download_limit;
    }

    public void setDownload_limit(String download_limit2) {
        this.download_limit = download_limit2;
    }

    public String getTime_limit() {
        return this.time_limit;
    }

    public void setTime_limit(String time_limit2) {
        this.time_limit = time_limit2;
    }

    public String getValidty_limit() {
        return this.validty_limit;
    }

    public void setValidty_limit(String validty_limit2) {
        this.validty_limit = validty_limit2;
    }

    public String getLimitation() {
        return this.limitation;
    }

    public void setLimitation(String limitation2) {
        this.limitation = limitation2;
    }

    public String getProfile_limitation() {
        return this.profile_limitation;
    }

    public void setProfile_limitation(String profile_limitation2) {
        this.profile_limitation = profile_limitation2;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner2) {
        this.owner = owner2;
    }
}
