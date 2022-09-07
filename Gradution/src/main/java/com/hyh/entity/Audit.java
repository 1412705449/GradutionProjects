package com.hyh.entity;

public class Audit {
    private int id;
    private int store_id;
    private String title;
    private String img;
    private String author;
    private String intro;
    private double score;
    private String newtime;
    private String typename;
    private String chap;
    private String content;
    private String create_time;
    private int order;
    private int judgment;
    private int storeChap;

    public int getStoreChap() {
        return storeChap;
    }

    public void setStoreChap(int storeChap) {
        this.storeChap = storeChap;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", store_id=" + store_id +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", author='" + author + '\'' +
                ", intro='" + intro + '\'' +
                ", score='" + score + '\'' +
                ", newtime='" + newtime + '\'' +
                ", typename='" + typename + '\'' +
                ", chap='" + chap + '\'' +
                ", content='" + content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", order=" + order +
                ", judgment=" + judgment +
                '}';
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getNewtime() {
        return newtime;
    }

    public void setNewtime(String newtime) {
        this.newtime = newtime;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getChap() {
        return chap;
    }

    public void setChap(String chap) {
        this.chap = chap;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
