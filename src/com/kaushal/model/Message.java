package com.kaushal.model;

public class Message {
    int id;
    String Text;
    String topic;

    public Message() {
    }

    public Message(int id, String text, String topic) {
        this.id = id;
        Text = text;
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}