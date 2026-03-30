package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class Interface {
    public String board_name;
    public String disabled;
    public String free_memory;
    public String total_memory;
    public String uptime;
    public String version;

    public Interface() {
    }

    public Interface(String free_memory2, String uptime2, String total_memory2, String disabled2, String board_name2, String version2) {
        this.free_memory = free_memory2;
        this.disabled = disabled2;
        this.board_name = board_name2;
        this.uptime = uptime2;
        this.total_memory = total_memory2;
        this.version = version2;
    }

    public String getfree_memory() {
        return this.free_memory;
    }

    public void setfree_memory(String free_memory2) {
        this.free_memory = free_memory2;
    }

    public String getuptime() {
        return this.uptime;
    }

    public void setuptime(String uptime2) {
        this.uptime = uptime2;
    }

    public String getTotalMemory() {
        return this.total_memory;
    }

    public void setTotalMemory(String total_memory2) {
        this.total_memory = total_memory2;
    }

    public String getDisabled() {
        return this.disabled;
    }

    public void setDisabled(String disabled2) {
        this.disabled = disabled2;
    }

    public String getboard_name() {
        return this.board_name;
    }

    public void setboard_name(String board_name2) {
        this.board_name = board_name2;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version2) {
        this.version = version2;
    }
}
