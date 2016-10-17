package com.hzit.test;

import com.hzit.dao.TblscoreMapper;
import com.hzit.entity.Tblscore;
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
 * Created by Administrator on 2016/9/9.
 */
public class Test_Tblscore {
    private SqlSession session;
    private TblscoreMapper tblscoreMapper;
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
            //通过session获取到TblscoreMapper接口的实现类对象
            tblscoreMapper=session.getMapper(TblscoreMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findAll(){
        List<Tblscore> list=tblscoreMapper.findAll();
        System.out.println("===============================");
        for (Tblscore s:list){
            System.out.print(s.getTblstudent().getStuName()+"\t\t");
            System.out.print(s.getTblcourse().getCourseName()+"\t\t");
            System.out.print(s.getScore());
            System.out.println("\n===============================");
        }
    }
}
