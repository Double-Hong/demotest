import com.example.demotest.Bridge_Info;
import com.example.demotest.userAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Connection;
import java.util.ArrayList;

public class Test {
    private static Connection dbConn = null;

    public static void main(String[] args) {
//        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Mysystem";
//
//        try {
//            //1.加载驱动
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            System.out.println("加载驱动成功！");
//            //2.连接
//            dbConn = DriverManager.getConnection(dbURL, "sa", "123456");
//            System.out.println("连接数据库成功！");
//            String sql="select * from Bridge_Info";
//            PreparedStatement statement=null;
//            statement=dbConn.prepareStatement(sql);
//            ResultSet res=null;
//            res=statement.executeQuery();
//            while(res.next()){
//                String bname=res.getString("bname");
//                System.out.println(bname);
//            }
//        }catch(Exception e) {
//            e.printStackTrace();
//            System.out.println("连接数据库失败！");
//        }
        ArrayList<Bridge_Info> infos=new ArrayList<>();
        infos= userAccess.ShowBridge();
        Gson gson =new GsonBuilder().create();
        System.out.println(gson.toJson(infos));

    }
}
