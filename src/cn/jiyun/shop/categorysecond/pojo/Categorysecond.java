package cn.jiyun.shop.categorysecond.pojo;

import java.io.Serializable;

public class Categorysecond implements Serializable {
    private Integer csid;

    private String csname;

    private Integer cid;

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname == null ? null : csname.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}