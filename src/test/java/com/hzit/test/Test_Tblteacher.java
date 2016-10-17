package com.hzit.test;

import com.hzit.dao.TblteacherMapper;
import com.hzit.entity.Tblclass;
import com.hzit.entity.Tblteacher;
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
public class Test_Tblteacher {
    private SqlSession session;
    private TblteacherMapper tblteacherMapper;
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
            tblteacherMapper=session.getMapper(TblteacherMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findAll(){
        List<Tblteacher> list=tblteacherMapper.findAll();
        for (Tblteacher t:list){
            List<Tblclass> tblclass=t.getTblclassList();
            for (Tblclass c:tblclass){
                System.out.println(t.getTeaName()+"\t\t所带班级名："+c.getCname());
            }
        }
    }
}
