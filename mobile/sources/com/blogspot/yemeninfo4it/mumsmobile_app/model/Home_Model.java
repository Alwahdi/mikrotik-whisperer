package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class Home_Model {
    Integer bitmap1;
    Integer imagers;
    String textdji;
    String textprice;

    public Integer getBitmap1() {
        return this.bitmap1;
    }

    public void setBitmap1(Integer bitmap12) {
        this.bitmap1 = bitmap12;
    }

    public Integer getImagers() {
        return this.imagers;
    }

    public void setImagers(Integer imagers2) {
        this.imagers = imagers2;
    }

    public String getTextdji() {
        return this.textdji;
    }

    public void setTextdji(String textdji2) {
        this.textdji = textdji2;
    }

    public String getTextprice() {
        return this.textprice;
    }

    public void setTextprice(String textprice2) {
        this.textprice = textprice2;
    }

    public Home_Model(Integer bitmap12, Integer imagers2, String textdji2, String textprice2) {
        this.bitmap1 = bitmap12;
        this.imagers = imagers2;
        this.textdji = textdji2;
        this.textprice = textprice2;
    }
}
