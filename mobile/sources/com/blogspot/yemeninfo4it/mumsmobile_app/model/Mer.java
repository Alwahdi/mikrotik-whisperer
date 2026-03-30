package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class Mer {
    public String ac;
    public String adh;
    public String adm;
    public String ah;
    public String amng;
    public String asa;

    public Mer(String adh2, String adm2, String ah2, String amng2, String ac2, String asa2) {
        this.adh = adh2;
        this.adm = adm2;
        this.ah = ah2;
        this.amng = amng2;
        this.ac = ac2;
        this.asa = asa2;
    }

    public String getAdh() {
        return this.adh;
    }

    public void setAdh(String adh2) {
        this.adh = adh2;
    }

    public String getAdm() {
        return this.adm;
    }

    public void setAdm(String adm2) {
        this.adm = adm2;
    }

    public String getAh() {
        return this.ah;
    }

    public void setAh(String ah2) {
        this.ah = ah2;
    }

    public String getAmng() {
        return this.amng;
    }

    public void setAmng(String amng2) {
        this.amng = amng2;
    }

    public String getAc() {
        return this.ac;
    }

    public void setAc(String ac2) {
        this.ac = ac2;
    }

    public String getAsa() {
        return this.asa;
    }

    public void setAsa(String asa2) {
        this.asa = asa2;
    }
}
