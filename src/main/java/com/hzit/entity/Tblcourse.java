package com.hzit.entity;


/**
 * Created by Administrator on 2016/9/9.
 */
public class Tblcourse {
    private String courseId;
    private String courseName;
    private Tblteacher tblteacher;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Tblteacher getTblteacher() {
        return tblteacher;
    }

    public void setTblteacher(Tblteacher tblteacher) {
        this.tblteacher = tblteacher;
    }
}
