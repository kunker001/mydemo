package com.example.kun.mydemo.model.req;

public class DataReqBean {

    private String area ;
    private String content ;
    private String isEvaluate ;
    private String isFinish ;
    private int pagesize ;
    private int skip ;
    private String sno ;

    public DataReqBean() {
    }

    public DataReqBean(String area, String content, String isEvaluate, String isFinish, int pagesize, int skip, String sno) {
        this.area = area;
        this.content = content;
        this.isEvaluate = isEvaluate;
        this.isFinish = isFinish;
        this.pagesize = pagesize;
        this.skip = skip;
        this.sno = sno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
