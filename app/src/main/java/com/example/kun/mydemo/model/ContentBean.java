package com.example.kun.mydemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContentBean {

    //private List<DataBean> content ;
    @SerializedName("content")
    @Expose
    private List<DataBean> content ;
    @SerializedName("size")
    @Expose
    private int size ;
    @SerializedName("totalPages")
    @Expose
    private int totalPages ;
    @SerializedName("totalElements")
    @Expose
    private int totalElements ;
    @SerializedName("last")
    @Expose
    private boolean last ;
    @SerializedName("first")
    @Expose
    private boolean first ;
    @SerializedName("numberOfElements")
    @Expose
    private int numberOfElements ;

    private int number ;

    public ContentBean() {
    }

    public ContentBean(List<DataBean> content, int size, int totalPages, int totalElements, boolean last, boolean first, int numberOfElements) {
        this.content = content;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.last = last;
        this.first = first;
        this.numberOfElements = numberOfElements;
    }

    public List<DataBean> getContent() {
        return content;
    }

    public void setContent(List<DataBean> content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static class DataBean {

        @SerializedName("id")
        @Expose
        private int id ;
        @SerializedName("content")
        @Expose
        private String content ;
        @SerializedName("code")
        @Expose
        private String code ;
        @SerializedName("area")
        @Expose
        private int area ;
        @SerializedName("address")
        @Expose
        private String address ;
        @SerializedName("telephone")
        @Expose
        private String telephone ;
        @SerializedName("repair_status")
        @Expose
        private int repair_status ;
        @SerializedName("repairman")
        @Expose
        private String repairman;
        @SerializedName("material")
        @Expose
        private String material ;
        @SerializedName("usecount")
        @Expose
        private int usecount ;
        @SerializedName("rate")
        @Expose
        private String rate ;
        @SerializedName("result")
        @Expose
        private String result ;
        @SerializedName("isEvaluate")
        @Expose
        private String isEvaluate ;
        @SerializedName("is_vaild")
        @Expose
        private String is_vaild ;
        @SerializedName("repair_time")
        @Expose
        private long repair_time ;
        @SerializedName("create_time")
        @Expose
        private long create_time ;
        @SerializedName("update_time")
        @Expose
        private long update_time ;
        @SerializedName("comments")
        @Expose
        private String comments ;

        public DataBean() {
        }

        public DataBean(int id, String content, String code, int area, String address, String telephone, int repair_status, String repairman, String material, int usecount, String rate, String result, String isEvaluate, String is_vaild, long repair_time, long create_time, long update_time, String comments) {
            this.id = id;
            this.content = content;
            this.code = code;
            this.area = area;
            this.address = address;
            this.telephone = telephone;
            this.repair_status = repair_status;
            this.repairman = repairman;
            this.material = material;
            this.usecount = usecount;
            this.rate = rate;
            this.result = result;
            this.isEvaluate = isEvaluate;
            this.is_vaild = is_vaild;
            this.repair_time = repair_time;
            this.create_time = create_time;
            this.update_time = update_time;
            this.comments = comments;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
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

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public int getRepair_status() {
            return repair_status;
        }

        public void setRepair_status(int repair_status) {
            this.repair_status = repair_status;
        }

        public String getRepairman() {
            return repairman;
        }

        public void setRepairman(String repairman) {
            this.repairman = repairman;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public int getUsecount() {
            return usecount;
        }

        public void setUsecount(int usecount) {
            this.usecount = usecount;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
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

        public long getRepair_time() {
            return repair_time;
        }

        public void setRepair_time(long repair_time) {
            this.repair_time = repair_time;
        }

        public long getCreate_time() {
            return create_time;
        }

        public void setCreate_time(long create_time) {
            this.create_time = create_time;
        }

        public long getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(long update_time) {
            this.update_time = update_time;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }
    }

}
