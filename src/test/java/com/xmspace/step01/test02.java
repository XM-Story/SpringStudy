package com.xmspace.step01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/2 22:29
 **/
public class test02 {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        //1.使用Spring默认机制instance of查询是否是FactoryBean实现类，如果是则返回getObject方法的对象
        Connection connection = (Connection) applicationContext.getBean("connection");
        //2.如果你不想这样，还是想获取ConnectionFactoryBean 则可以加上 & 符号
        //Connection connection = (Connection) applicationContext.getBean("&connection");
        System.out.println(connection);
    }
}
