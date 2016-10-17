package com.hzit.test;

import com.hzit.entity.Tblstudent;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public class Findstudent {
    private SqlSession session;
    @Before
    public void init() {
        try {
            //有一个配置文件，需要利用输入流读取到这配置文件
            //加载mybatis的配置文件（它也加载关联的映射文件）
            Reader reader = Resources.getResourceAsReader("peizhi.xml");
            //有这个输入流，通过这个输入流创建session工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建能执行映射文件中sql的sqlSession
            //SqlSession对象是JAVA程序和数据库之间的一段会话过程，Javac程序炒作数据库的操作都
            //封装到这个SqlSession对象中
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findAll(){
        List<Tblstudent> list=session.selectList("com.hzit.dao.TblstudentMapper.findstudent");
        for (Tblstudent s:list){
            System.out.println(s.getStuName());
        }
    }
    @Test
    public void findByid(){
        Tblstudent stu=session.selectOne("com.hzit.dao.TblstudentMapper.findByid");
        System.out.println(stu.getStuId()+"\t"+stu.getStuName()+"\t"+stu.getStuSex());
    }
    @Test
    public void addTblstudent(){
        Tblstudent stu=new Tblstudent();
        stu.setStuId("2000");
        stu.setStuName("小小鸟");
        stu.setStuAge("19");
        stu.setStuSex("男");
        stu.setStuPass("8888");
        try{
        session.insert("com.hzit.dao.TblstudentMapper.addTblstudent",stu);
        session.commit();
        }catch (Exception e){
            session.rollback();
        }
    }
    @Test
    public void update(){

    }
}
