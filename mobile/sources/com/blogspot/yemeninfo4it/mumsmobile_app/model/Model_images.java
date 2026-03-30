package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class Model_images {
    String al_imagepath;
    String str_folder;

    public Model_images() {
    }

    public Model_images(String str_folder2, String al_imagepath2) {
        this.str_folder = str_folder2;
        this.al_imagepath = al_imagepath2;
    }

    public String getStr_folder() {
        return this.str_folder;
    }

    public void setStr_folder(String str_folder2) {
        this.str_folder = str_folder2;
    }

    public String getAl_imagepath() {
        return this.al_imagepath;
    }

    public void setAl_imagepath(String al_imagepath2) {
        this.al_imagepath = al_imagepath2;
    }
}
