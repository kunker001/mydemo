package com.example.kun.mydemo.model.req;

public class UpdateBean {

    private String address ;
    private int id ;
    private String area;
    private String telephone;
    private String content ;
    private String isEvaluate ;
    private String is_vaild;
    private String repair_status ;
    private int repairmanId ;

    public UpdateBean(String content , String address, int id, String area, String telephone) {
        this.address = address;
        this.id = id;
        this.area = area;
        this.telephone = telephone;
        this.content = content ;
    }


    public UpdateBean(String address, int id, String area, String telephone, String content, String isEvaluate, String is_vaild, String repair_status, int repairmanId) {
        this.address = address;
        this.id = id;
        this.area = area;
        this.telephone = telephone;
        this.content = content;
        this.isEvaluate = isEvaluate;
        this.is_vaild = is_vaild;
        this.repair_status = repair_status;
        this.repairmanId = repairmanId;
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

    public String getIsEvaluate() {
        return isEvaluate;
    }

    public void setIsEvaluate(String isEvaluate) {
        this.isEvaluate = isEvaluate;
    }

    public String getIs_vaild() {
        return is_vaild;
    }

    public void setIs_vaild(String is_vaild) {
        this.is_vaild = is_vaild;
    }

    public String getRepair_status() {
        return repair_status;
    }

    public void setRepair_status(String repair_status) {
        this.repair_status = repair_status;
    }

    public int getRepairmanId() {
        return repairmanId;
    }

    public void setRepairmanId(int repairmanId) {
        this.repairmanId = repairmanId;
    }
}
