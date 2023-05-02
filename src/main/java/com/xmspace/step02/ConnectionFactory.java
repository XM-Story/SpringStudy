package com.xmspace.step02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/2 23:02
 **/
public class ConnectionFactory {
    //以前的开发写了这么一段代码帮我们去创建连接对象。
    Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_plan", "root", "123456");
        return c;
    }
}
