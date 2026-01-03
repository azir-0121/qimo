package junit.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//学习数据库增删改的JDBC访问操作方法
public class DBProcessTest1 {
    @Test
    public void testInsert() throws Exception{
        String sql = "insert into t_user(userid,username,utid,pwd) " +
                "values('lism','李世民',2,'666666')";
        //加载驱动程序(1)
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动程序加载成功");
        String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String pwd = "123456";
        //获取数据库的连接对象Connection（2）
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("数据库连接创建成功");
        //创建执行指定SQL命令的语句对象（3）
        PreparedStatement ptmt = conn.prepareStatement(sql);
        int rows = ptmt.executeUpdate(); //执行SQL命令（4）
        System.out.println("受影响行数：" + rows);
        ptmt.close(); //注意关闭顺序（5）
        conn.close(); //关闭连接
    }

    @Test
    public void testUpdate() throws Exception{
        String sql = "update t_user set pwd = '1234567'," +
                "mobile = '13900000004',mail = '00004@qq.com'" +
                "where userid = 'lism'";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动程序加载成功");
        String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("数据库连接创建成功");
        //创建执行指定SQL命令的语句对象
        PreparedStatement ptmt = conn.prepareStatement(sql);
        int rows = ptmt.executeUpdate();
        System.out.println("受影响行数：" + rows);
        ptmt.close(); //注意关闭顺序
        conn.close(); //关闭连接
    }

    @Test
    public void testDelete() throws Exception{
        String sql = "delete from t_user where userid = 'lism'";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动程序加载成功");
        String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("数据库连接创建成功");
        //创建执行指定SQL命令的语句对象
        PreparedStatement ptmt = conn.prepareStatement(sql);
        int rows = ptmt.executeUpdate();
        System.out.println("受影响行数：" + rows);
        ptmt.close(); //注意关闭顺序
        conn.close(); //关闭连接
    }
}
