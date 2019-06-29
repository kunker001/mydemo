package com.example.kun.mydemo.model;

public class BarCodeBean {

    private int area ;
    private String address ;

    public BarCodeBean() {
    }

    public BarCodeBean(int area, String address) {
        this.area = area;
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
