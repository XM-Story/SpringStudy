package com.xmspace.step02;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/2 21:50
 **/
//1.首先实现FactoryBean并且引入泛型，帮我们创建Connection对象
@Data
public class ConnectionFactoryBean implements FactoryBean<Connection> {
    //2.使用xml配置这些属性 进行解耦操作
    private String driver;
    private String url;
    private String user;
    private String password;
    //3.使用mysql驱动管理连接数据库
    @Override
    public Connection getObject() throws Exception {
        Connection connection= DriverManager.getConnection(url, user, password);
        return connection;
    }
    //4.告诉返回值类型
    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }
    //5.是否创建单例对象 因为数据库设计到事务提交这里肯定是false,每个人连接都需要创建新对象
    @Override
    public boolean isSingleton() {
        return false;
    }
}
