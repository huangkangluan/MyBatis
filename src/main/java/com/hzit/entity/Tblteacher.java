package com.hzit.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public class Tblteacher {
    private String teaId;
    private String teaName;
    private List<Tblclass> tblclassList;

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public List<Tblclass> getTblclassList() {
        return tblclassList;
    }

    public void setTblclassList(List<Tblclass> tblclassList) {
        this.tblclassList = tblclassList;
    }
}
