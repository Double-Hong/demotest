package com.example.demotest;

import java.sql.*;
import java.util.ArrayList;

public class userAccess {
    static String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Mysystem";
    private static Connection dbConn = null;
    public static Connection getConn()
    {
        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("加载驱动成功！");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, "sa", "123456");
            System.out.println("连接数据库成功！");
        return dbConn;
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
            return null;
        }
    }
    public static ArrayList<Bridge_Info> ShowBridge()
    {
        ArrayList<Bridge_Info> results = new ArrayList<>();

        Connection conn=getConn();

        String sql="select * from Bridge_Info";
        try {
            PreparedStatement p=conn.prepareStatement(sql);
            ResultSet set=p.executeQuery();
            while(set.next())
            {
                String bno=set.getString("bno");
                String bname=set.getString("bname");
                double longitude= set.getDouble("longitude");
                double latitude =set.getDouble("latitude");
                String describle=set.getString("describe");
                Bridge_Info infor=new Bridge_Info(bno,bname,longitude,latitude,describle);
                results.add(infor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;

    }
    public static void Check()
    {
        Connection conn=getConn();
        String sql = "select * from Bridge_Info";
        PreparedStatement statement=null;
        try {
            statement=conn.prepareStatement(sql);
            ResultSet res=null;
            res=statement.executeQuery();
            while(res.next()){
                String bno=res.getString("bno");
                String bname=res.getString("bname");
                String longi=res.getString("longitude");
                String lati=res.getString("latitude");
                System.out.println(bno);
                System.out.println(bname);
                System.out.println(longi);
                System.out.println(lati);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
