package junit.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

    @Test
    public void testDBConnect()  {
        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动程序加载成功");
            String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
            String username = "root";
            String pwd = "123456";
            Connection conn = DriverManager.getConnection(url,username,pwd);
            System.out.println("数据库连接创建成功");
            conn.close(); //关闭连接
        } catch (ClassNotFoundException e) {
            System.out.println("驱动程序加载失败");
            e.printStackTrace();
        }catch (SQLException e) {
            System.out.println("数据库连接创建失败");
            e.printStackTrace();
        }
        //mysql 8.0: com.mysql.cj.jdbc.Driver
    }
}
