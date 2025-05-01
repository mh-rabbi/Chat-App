package com.iubat.chatapp;

public class MessageModel {
    String id;
    String name;
    String message;
    long time;

    public MessageModel() {
        // Required empty public constructor
    }
    public MessageModel(String id, String name, String message, long time) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public long getTime() {
        return time;
    }
}
