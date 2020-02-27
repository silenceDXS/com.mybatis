package com.ssm.MybatiesUntils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisUntils {
    private  static SqlSessionFactory sqlSessionFactory=null;
    static {
        try {
            Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);

        }catch (Exception e){
            e.getStackTrace();
        }

    }

    public    SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }

}
