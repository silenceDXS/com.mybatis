package com.ssm.test;


import com.ssm.MybatiesUntils.MybatisUntils;
import com.ssm.po.Card_Person;
import com.ssm.po.Customer;

import com.ssm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.tools.ant.types.Resource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;

public class MybatisTest {
    @Test
    public void findCustomerByIdTest() throws IOException {
        //1. 读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2. 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //3. 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4. SqlSession执行映射文件中定义的SQL，并返回映射结果
        Customer customer = sqlSession.selectOne("resources.com.ssm.mapper" +
                ".CustomerMapper.findCustomerById", 1);
        //5. 打印
        System.out.println(customer.toString());


        List<Customer> list = sqlSession.selectList("resources.com.ssm.mapper" +
                ".CustomerMapper.findCustomerByName", "j");
        for (Customer customer1 : list) {
            System.out.println(customer1);
        }

        //6. 关闭SqlSession
        sqlSession.close();


    }

    @Test
    public void addCustomerTest() throws IOException {
        MybatisUntils mybatisUntils = new MybatisUntils();
        SqlSession sqlSession = mybatisUntils.getSession();
        Customer customer = new Customer();
        customer.setId(4);
        customer.setUsername("邓星颖");
        customer.setJobs("学生");
        customer.setPhone("123123123");

        int result = sqlSession.insert("resources.com.ssm.mapper.CustomerMapper.addCustomer", customer);
        if (result > 0) {
            System.out.println("已经成功插入" + result + "条数据");
        } else {
            System.out.println("插入失败");
        }
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updataCustomer() throws IOException {
        MybatisUntils mybatisUntils = new MybatisUntils();
        SqlSession sqlSession = mybatisUntils.getSession();
        int result = sqlSession.delete("resources.com.ssm.mapper.CustomerMapper.deleteCustomer", 4);

        if (result > 0) {
            System.out.println("已经成功删除" + result + "条数据");
        } else {
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteCustomer() throws IOException {
        MybatisUntils mybatisUntils = new MybatisUntils();
        SqlSession sqlSession = mybatisUntils.getSession();
        Customer customer = new Customer();
        customer.setId(4);
        customer.setUsername("hello");
        customer.setPhone("1232136564");
        customer.setJobs("主播");
        int result = sqlSession.update("resources.com.ssm.mapper.CustomerMapper.updataCustomer", customer);
        if (result > 0) {
            System.out.println("已经成功更新" + result + "条数据");
        } else {
            System.out.println("更新失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void findAllUser(){
        SqlSession sqlSession=new MybatisUntils().getSession();
        List<User> list=sqlSession.selectList("resources.com.ssm.mapper.UserMapper.findAllUser");
        for (User user : list) {
            System.out.println(user);
        }

    }

    @Test
    public void  findAllUserByDynamic(){
        SqlSession sqlSession=new MybatisUntils().getSession();
        Customer customer=new Customer();
        customer.setUsername("邓星颖");
        customer.setJobs("学生");
        List<Customer> list=sqlSession.selectList("resources.com.ssm.mapper.CustomerMapper.findUserByDynamic",customer);
        for(Customer customer1:list){
            System.out.println(customer1);
        }




        }
    @Test
    public void  findCardWithPerson() throws IOException {
       String str="mybatis-config.xml";
        Reader reader=Resources.getResourceAsReader(str);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession=sqlSessionFactory.openSession();

        System.out.println(sqlSession);
        Card_Person cardPerson=sqlSession.selectOne("resources.com.ssm.mapper.PersonMapper.findPersonById",1);
        System.out.println(cardPerson);





    }

}