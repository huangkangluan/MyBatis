package com.hzit.entity;

/**
 * Created by Administrator on 2016/9/9.
 */
public class Tblclass {
    private String cid;
    private String cname;
    private Tblteacher tblteacher;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Tblteacher getTblteacher() {
        return tblteacher;
    }

    public void setTblteacher(Tblteacher tblteacher) {
        this.tblteacher = tblteacher;
    }
}
