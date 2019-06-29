package com.example.kun.mydemo.model.req;

public class NewRepairBean {

    private String address ;
    private String area ;
    private String code ;
    private String comments ;
    private String content ;
    private int repair_status ;
    private String telephone ;

    public NewRepairBean() {
    }

    public NewRepairBean(String address, String area, String code, String comments, String content, int repair_status, String telephone) {
        this.address = address;
        this.area = area;
        this.code = code;
        this.comments = comments;
        this.content = content;
        this.repair_status = repair_status;
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRepair_status() {
        return repair_status;
    }

    public void setRepair_status(int repair_status) {
        this.repair_status = repair_status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
