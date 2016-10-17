package com.hzit.test;

import com.hzit.dao.TblstudentMapper;
import com.hzit.entity.Tblstudent;
import com.hzit.entity.TblstudentTiaoJian;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/9/8.
 */
public class Test_Tblstudent {
    private SqlSession session;
    private TblstudentMapper tblstudentMapper;
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
            session = sessionFactory.openSession(true);
            //通过session获取到TblstudentMapper接口的实现类对象
            tblstudentMapper=session.getMapper(TblstudentMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findByType(){
        List<Tblstudent> list=tblstudentMapper.findByType(3);
        for (Tblstudent s:list){
            System.out.println(s.getStuName()+"\t"+s.getStuAge());
        }
    }
    @Test
    public void findTiaoJian(){
        TblstudentTiaoJian tiaojian=new TblstudentTiaoJian();
        tiaojian.setMinage(19);
        List<Tblstudent> list=tblstudentMapper.findTiaoJian(tiaojian);
        for (Tblstudent s:list){
            System.out.println(s.getStuName()+"\t"+s.getStuAge());
        }
    }
    @Test
    public void findTblstudent(){
        Tblstudent stu=new Tblstudent();
        //stu.setStuAge("19");
        stu.setStuName("张");
        List<Tblstudent> list=tblstudentMapper.findTblstudent(stu);
        for (Tblstudent s:list){
            System.out.println(s.getStuName()+"\t"+s.getStuAge()+"\t"+s.getStuSex());
        }
    }
    @Test
    public void find_StuName_StuAge(){
        Map map=new HashMap();
        map.put("stuAge",18);
        List<Tblstudent> list=tblstudentMapper.find_StuName_StuAge(map);
        for (Tblstudent s:list){
            System.out.println(s.getStuName()+"\t"+s.getStuAge());
        }
    }
    @Test
    public void findAll(){
        List<Tblstudent> list=tblstudentMapper.findAll();
        for (Tblstudent s:list){
            System.out.print(s.getStuId()+"\t");
            System.out.print(s.getStuName()+"\t");
            System.out.print(s.getStuAge()+"\t");
            System.out.print(s.getStuSex()+"\t");
            System.out.print(s.getStuPass()+"\t");
            System.out.println();
        }
    }
    @Test
    public void findByid(){
        Tblstudent stu=tblstudentMapper.findByid("1005");
        System.out.print(stu.getStuId()+"\t");
        System.out.print(stu.getStuName()+"\t");
        System.out.print(stu.getStuAge()+"\t");
        System.out.print(stu.getStuSex()+"\t");
        System.out.print(stu.getStuPass() + "\t");
    }
    @Test
    public void addTblstudent(){
        Tblstudent stu=new Tblstudent();
        //UUID.randomUUID().toString()提供的一个自动生成主键的方法
        stu.setStuId(UUID.randomUUID().toString());
        stu.setStuName("深圳人");
        stu.setStuAge("19");
        stu.setStuSex("男");
        stu.setStuPass("8888");
        try {
            int num = tblstudentMapper.addTblstudent(stu);
            session.commit();
            System.out.println("影响了" + num + "行");
        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void updateTblstudent(){
        Tblstudent stu=new Tblstudent();
        stu.setStuId("2000");
        stu.setStuName("隔壁老王");
        stu.setStuAge("20");
        stu.setStuSex("男");
        stu.setStuPass("0000");
        try {
        int num=tblstudentMapper.updateTblstudent(stu);
            session.commit();
            System.out.println("影响了" + num + "行");
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }
    @Test
    public void deleteTblstudent(){
        try {
            int num = tblstudentMapper.deleteTblstudent("2000");
            session.commit();
            System.out.println("影响了" + num + "行");
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
    }
}
