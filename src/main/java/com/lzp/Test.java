package com.lzp;

import com.lzp.dao.UserMapper;
import com.lzp.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by LiZhanPing on 2019/12/16.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        //1、读取SqlMapConfig.xml配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //2、构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、打开SqlSession
        SqlSession session = sqlSessionFactory.openSession();
        //4、获取Mapper接口对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //5、操作Mapper接口对象的方法操作数据库
        User user = userMapper.findById(1);
        //6、业务处理
        System.out.println("name:"+user.getName()+",age:"+user.getAge());
    }
}
