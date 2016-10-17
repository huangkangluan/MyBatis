package com.hzit.dao;


import com.hzit.entity.Tblstudent;
import com.hzit.entity.TblstudentTiaoJian;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/8.
 */
public interface TblstudentMapper {
    
    public List<Tblstudent> findByType(@Param("flag") int flag);
    public List<Tblstudent> findTiaoJian(TblstudentTiaoJian tiaojian);
    public List<Tblstudent> findTblstudent(Tblstudent tblstudent);
    public List<Tblstudent> find_StuName_StuAge(Map map);
    /**
     * 查询所有学员信息
     * @return
     */
    public List<Tblstudent> findAll();

    /**
     * 根据ID查询指定学员信息
     * @param stuid
     * @return
     */
    public Tblstudent findByid(String stuid);

    /**
     * 增加学员信息
     * @param stu
     * @return
     */
    public int addTblstudent(Tblstudent stu);

    /**
     * 修改学员信息
     * @param stu
     * @return
     */
    public int updateTblstudent(Tblstudent stu);

    /**
     * 删除学员信息
     * @param stuid
     * @return
     */
    public int deleteTblstudent(String stuid);
}
