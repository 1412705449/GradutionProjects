package com.hyh.entity;

public class Message {
    private int id;
    private int user_id;
    private int store_id;
    private String username;
    private String content;
    private String newtime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewtime() {
        return newtime;
    }

    public void setNewtime(String newtime) {
        this.newtime = newtime;
    }
}
