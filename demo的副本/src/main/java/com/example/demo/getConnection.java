package com.example.demo;
import java.sql.*;

class getConnection {
    private static final String driver = "com.mysql.cj.jdbc.Driver";//jdbc
    private static final String url = "jdbc:mysql://localhost:3306/A";//URL指向要访问的数据库名mysql
    private static final String user = "root";//MySQL用户名
    private static final String password = "";//密码
    private static Connection con;
    private static PreparedStatement statement;
    //private Statement statement;
     getConnection()throws Exception//链接的构造函数
    {
                Class.forName(driver);// 指定连接类型
             con = DriverManager.getConnection(url, user, password);// 获取连接
        if(con.isClosed()) {System.out.println("链接成功！");}
    }

     void close()throws Exception//关闭当前链接和查询语句
    {
            this.con.close();
            this.statement.close();
    }


    static void show(String sql)throws Exception //数据库的查询
    {
        ResultSet rs;
        //getConnection con = new getConnection();
        Statement statement = con.createStatement(); // 准备执行语句
        rs = statement.executeQuery(sql);
        String name;
        int age;
        System.out.println("--------------");
        while (rs.next()) {
            name = rs.getString("name");
            age = rs.getInt("age");
            System.out.println(name + "\t " + age);
        }
        System.out.println("--------------");
    }

    protected static void update(String sql)throws Exception {
        statement = con.prepareStatement(sql);
        statement.executeUpdate();
         System.out.println("更新成功！！");
    }
    protected static void insert(String sql)throws Exception {
        statement = con.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("插入成功！！");
    }
    protected static void delete(String sql)throws Exception {
        statement = con.prepareStatement(sql);
        statement.executeUpdate();
        System.out.println("删除成功！！");
    }

}
