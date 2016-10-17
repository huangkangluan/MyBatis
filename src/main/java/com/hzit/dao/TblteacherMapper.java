package com.hzit.dao;

import com.hzit.entity.Tblteacher;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface TblteacherMapper {
    public List<Tblteacher> findAll();
    public Tblteacher findByid(String teaid);
    public int addTblteacher (Tblteacher tblteacher);
    public int updateTblteacher (Tblteacher tblteacher);
    public int deleteTblteacher (String teaid);
}
