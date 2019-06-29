package com.example.kun.mydemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("id")
    @Expose
    private int id ;
    @SerializedName("sno")
    @Expose
    private String sno ;
    @SerializedName("name")
    @Expose
    private String name ;
    @SerializedName("role")
    @Expose
    private int role ;

    public UserInfo() {
    }

    public UserInfo(int id, String sno, String name, int role) {
        this.id = id;
        this.sno = sno;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
