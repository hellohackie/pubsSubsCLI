package com.kaushal.model;

import java.util.HashSet;
import java.util.List;

public class Topic {
    String name;
    HashSet<String> userList;
    List<Message> messageList;

    public Topic(String name) {
        this.name = name;
    }

    public void addMessage(Message message){
        messageList.add(message);
    }

    public void addUsers(String user){
        userList.add(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getUserList() {
        return userList;
    }

    public void setUserList(HashSet<String> userList) {
        this.userList = userList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}