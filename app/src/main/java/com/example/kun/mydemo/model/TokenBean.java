package com.example.kun.mydemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenBean {

    @SerializedName("token")
    @Expose
    private String token ;
    @SerializedName("expiresIn")
    @Expose
    private String expiresIn ;

    public TokenBean(String token, String expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
}
