package com.example.kun.mydemo.adapter;

import java.io.Serializable;

public class Baoxiu implements Serializable{

    private int id ;
    private String code ;
    private String address ;
    private String date ;
    private String state ;
    private String content ;
    private String tel ;
    private int area ;

    public Baoxiu() {
    }

    public Baoxiu( String content , String address, String state, String date ,String tel , int area , int id) {
        this.code = code;
        this.address = address;
        this.date = date;
        this.state = state;
        this.content = content;
        this.tel = tel ;
        this.area = area ;
        this.id = id ;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
