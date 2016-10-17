package com.hzit.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2016/9/8.
 */
public class TestJoin {
    //测试一下是否可以连接数据
    @Test
    public void testjoin(){
        try {
            //有一个配置文件，需要利用输入流读取到这配置文件
            //加载mybatis的配置文件（它也加载关联的映射文件）
            Reader reader = Resources.getResourceAsReader("peizhi.xml");
            //有这个输入流，通过这个输入流创建session工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建能执行映射文件中sql的sqlSession
            //SqlSession对象是JAVA程序和数据库之间的一段会话过程，Javac程序炒作数据库的操作都
            //封装到这个SqlSession对象中
            SqlSession session = sessionFactory.openSession();
            System.out.println(session);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
