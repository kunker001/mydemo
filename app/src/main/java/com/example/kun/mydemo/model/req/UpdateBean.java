package com.example.kun.mydemo.model.req;

public class UpdateBean {

    private String address ;
    private int id ;
    private String area;
    private String telephone;
    private String content ;

    public UpdateBean(String content , String address, int id, String area, String telephone) {
        this.address = address;
        this.id = id;
        this.area = area;
        this.telephone = telephone;
        this.content = content ;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
