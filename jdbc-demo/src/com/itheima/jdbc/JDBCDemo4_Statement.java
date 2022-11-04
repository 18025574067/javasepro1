package com.itheima.jdbc;

import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
    JDBC API详解: Statement.
 */
public class JDBCDemo4_Statement {
    /**
        执行DML语句.
     */
    @Test
    public void testDML() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接 如果连接是本地的MySQL, 并且端口是3306, 可以简化书写.
        String url = "jdbc:mysql:///db1?useSSL=false";
        String user = "root";
        String password = "mysql";
        Connection conn =  DriverManager.getConnection(url, user, password);

        // 3. 定义sql语句
        String sql = "update account set money = 800 where id = 5";

        // 4. 获取执行sql的对象 Statement;
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int count = stmt.executeUpdate(sql); // 执行完DML语句, 受影响的行数.

        // 6. 处理结果
//        System.out.println(count);
        if (count > 0){
            System.out.println("修改成功");
        }else {
            System.out.println("执行失败!");
        }
        // 7. 释放资源
        stmt.close();
        conn.close();
    }

    @Test
    public void testDDL() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        // 2. 获取连接 如果连接是本地的MySQL, 并且端口是3306, 可以简化书写.
        String url = "jdbc:mysql:///db1?useSSL=false";
        String user = "root";
        String password = "mysql";
        Connection conn =  DriverManager.getConnection(url, user, password);

        // 3. 定义sql语句
        String sql = "create database db3";

        // 4. 获取执行sql的对象 Statement;
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int count = stmt.executeUpdate(sql); // 执行完DDL语句, 受影响的行数.

        // 6. 处理结果
//        System.out.println(count);
        // 执行DDL, 返回可能是0.
        if (count > 0){
            System.out.println("修改成功");
        }else {
            System.out.println("执行失败!");
        }
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}
