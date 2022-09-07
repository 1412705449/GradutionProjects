package com.hyh.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String create_time;
    private int judgment;    //判断是冻结 0  还是正常 1   默认为1

    public int getJudgment() {
        return judgment;
    }

    public void setJudgment(int judgment) {
        this.judgment = judgment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
