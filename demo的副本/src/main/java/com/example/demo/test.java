package com.example.demo;

import java.sql.Connection;

public class test
{
    public static void main(String [] a) throws Exception {
        getConnection con= new getConnection();
        con.show("select * from user");
        con.update("update user set age=20 where age=24");
        con.show("select * from user");
        con.insert("insert into user values(null, 'zhangsan', 28)");
        con.show("select * from user");
        con.delete("delete from user where name = 'zhangsan'");
        con.show("select * from user");
    }
}
