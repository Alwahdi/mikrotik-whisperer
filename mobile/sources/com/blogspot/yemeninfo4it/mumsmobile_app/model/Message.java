package com.blogspot.yemeninfo4it.mumsmobile_app.model;

public class Message {
    private CharSequence sender;
    private CharSequence text;
    private long timestamp = System.currentTimeMillis();

    public Message(CharSequence text2, CharSequence sender2) {
        this.text = text2;
        this.sender = sender2;
    }

    public CharSequence getText() {
        return this.text;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public CharSequence getSender() {
        return this.sender;
    }
}
