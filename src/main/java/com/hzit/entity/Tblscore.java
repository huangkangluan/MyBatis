package com.hzit.entity;

/**
 * Created by Administrator on 2016/9/9.
 */
public class Tblscore {
    private Tblstudent tblstudent;
    private Tblcourse tblcourse;
    private String score;

    public Tblstudent getTblstudent() {
        return tblstudent;
    }

    public void setTblstudent(Tblstudent tblstudent) {
        this.tblstudent = tblstudent;
    }

    public Tblcourse getTblcourse() {
        return tblcourse;
    }

    public void setTblcourse(Tblcourse tblcourse) {
        this.tblcourse = tblcourse;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
