package cn.jiyun.shop.category.pojo;

import java.io.Serializable;
import java.util.List;

import cn.jiyun.shop.categorysecond.pojo.Categorysecond;

public class Category implements Serializable{
    private Integer cid;

    private String cname;
    
    //一对多
    private List<Categorysecond> cslist;
    
	public List<Categorysecond> getCslist() {
		return cslist;
	}

	public void setCslist(List<Categorysecond> cslist) {
		this.cslist = cslist;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
}