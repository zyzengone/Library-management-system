package com.how2java.tmall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }
        try(
                Connection c = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/tmall_springboot?useUnicode&characterEncoding=utf8","root","admin");
                Statement s = c.createStatement()
                )
        {
            for (int i = 0; i < 10; i++) {
                String sqlFormat = "insert into category values(null,'测试')";
                String sql = String.format(sqlFormat,i);
                s.execute(sql);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
