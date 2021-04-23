package com.kaushal.model;

public class User {
    int type;
    String name;

    public User() {
    }

    public User(String typeS, String name) {
        if(typeS.equals("ADMIN"))
            this.type = 0;
        else
            this.type = 1;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}