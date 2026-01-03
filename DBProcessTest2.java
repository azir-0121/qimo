package junit.test;

import dbc.DBConnction;
import org.junit.Test;

import java.sql.*;

/**
 * 学习基于预处理命令的增、删、查、改的操作
 */
public class DBProcessTest2 {
    private DBConnction dbc = new DBConnction();

    @Test
    public void testInsert() throws Exception{
        String userid = "qinsh";
        String username2 = "秦始皇";
        int usertype = 2;
        String pwd2 = "666666";

        String sql = "insert into t_user(userid,username,utid,pwd) " +
                "values(?,?,?,?)";

        Connection conn = dbc.getConnection();

        //创建执行指定SQL命令的语句对象（3）
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //将实际参数替换SQL命令中的？
        ptmt.setString(1,userid);
        ptmt.setString(2,username2);
        ptmt.setInt(3,usertype);
        ptmt.setString(4,pwd2);

        int rows = ptmt.executeUpdate(); //执行SQL命令（4）
        System.out.println("受影响行数：" + rows);
        dbc.closeConnection(null,ptmt,conn);
    }

    //学习如何返回insert数据后，新实体的主键值
    @Test
    public void testInsert2() throws Exception{
        //自动编号的主键不能被设置为手动添加，因此SQL中不能出现
        String sql ="insert into t_hotel(hotelname,userid)" +
                " values(?,?)";
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
        PreparedStatement ptmt = conn.prepareStatement(
                sql,
                PreparedStatement.RETURN_GENERATED_KEYS);
        ptmt.setString(1,"明凡居连锁酒店（杨林大学城店）");
        ptmt.setString(2,"admin1");
        int rows = ptmt.executeUpdate();
        if(rows>0){
            ResultSet rs = ptmt.getGeneratedKeys(); //从语句对象中获取保存有生成主键的结果集
            rs.next();
            System.out.println("主键ID:" + rs.getInt(1));
        }else{
            System.out.println("添加酒店数据失败");
        }
        ptmt.close();
        conn.close();
    }

    @Test
    public void testUpdate() throws Exception{
        String userid = "qinsh";
        String pwd2 = "123456";
        String mobile = "13900000001";
        String mail = "000001@qq.com";
        String sql = "update t_user set pwd = ?,mobile = ?,mail = ?" +
                " where userid = ?";

        Connection conn = dbc.getConnection();

        //创建执行指定SQL命令的语句对象
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //将实际修改的内容替换SQL命令中的?
        ptmt.setString(1,pwd2);
        ptmt.setString(2,mobile);
        ptmt.setString(3,mail);
        ptmt.setString(4,userid);

        int rows = ptmt.executeUpdate();
        System.out.println("受影响行数：" + rows);
        dbc.closeConnection(null,ptmt,conn);
    }

    @Test
    public void testDelete() throws Exception{
        String userid = "qinsh";
        String sql = "delete from t_user where userid = ?";
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

        ptmt.setString(1,userid);

        int rows = ptmt.executeUpdate();
        System.out.println("受影响行数：" + rows);
        ptmt.close(); //注意关闭顺序
        conn.close(); //关闭连接
    }

    @Test
    public void testSelect1() throws Exception{
        String sql = "select * from t_user where utid = ?";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动程序加载成功");
        String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("数据库连接创建成功");
        //创建执行指定SQL命令的语句对象
        PreparedStatement ptmt = conn.prepareStatement(
                sql
                ,ResultSet.TYPE_SCROLL_INSENSITIVE
                ,ResultSet.CONCUR_READ_ONLY);
        ptmt.setInt(1,2); //设置要查询的用户类别码为2（普通用户）
        ResultSet rs = ptmt.executeQuery();
        //next()取第一条记录
        rs.next();
        String uname = rs.getString("username");
        int utid = rs.getInt("utid");
        System.out.println(rs.getRow() +":"+ uname + "," + utid);
        //next()取第二条记录
        rs.next();
        uname = rs.getString("username");
        utid = rs.getInt("utid");
        System.out.println(rs.getRow() +":"+ uname + "," + utid);
        //last()取最后一条记录
        rs.last();
        uname = rs.getString("username");
        utid = rs.getInt("utid");
        System.out.println(rs.getRow() +":"+ uname + "," + utid);
        rs.previous();
        uname = rs.getString("username");
        utid = rs.getInt("utid");
        System.out.println(rs.getRow() +":"+ uname + "," + utid);
        rs.first();
        uname = rs.getString("username");
        utid = rs.getInt("utid");
        System.out.println(rs.getRow() +":"+ uname + "," + utid);
        rs.absolute(5);  //直接跳转到第5行
        uname = rs.getString("username");
        utid = rs.getInt("utid");
        System.out.println(rs.getRow() +":"+ uname + "," + utid);
        //关闭数据库
        rs.close();
        ptmt.close();
        conn.close();
    }

    @Test
    public void testSelect2() throws Exception{
        String sql = "select * from t_user where utid = ?";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动程序加载成功");
        String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("数据库连接创建成功");
        //创建执行指定SQL命令的语句对象
        PreparedStatement ptmt = conn.prepareStatement(
                sql
                ,ResultSet.TYPE_SCROLL_INSENSITIVE
                ,ResultSet.CONCUR_READ_ONLY);
        ptmt.setInt(1,2); //设置要查询的用户类别码为2（普通用户）
        ResultSet rs = ptmt.executeQuery();
        while (rs!=null && rs.next()){
            String uname = rs.getString("username");
            int utid = rs.getInt("utid");
            System.out.println(rs.getRow() +":"+ uname + "," + utid);
        }
        rs.close();  ptmt.close(); conn.close();
    }

    @Test   //调用up_getsystime() 存储过程
    public void testCallProcedure1() throws Exception{
        String sql = "{call up_getsystime()}";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动程序加载成功");
        String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("数据库连接创建成功");
        CallableStatement ctmt = conn.prepareCall(sql);  //调用存储过程需要使用CallableStatement
        ResultSet rs = ctmt.executeQuery();
        if(rs!=null && rs.next()){
            System.out.println(rs.getObject(1));
        }
        rs.close(); ctmt.close(); conn.close();
    }

    @Test   //调用up_delhotel(hotelid) 存储过程
    public void testCallProcedure2() throws Exception{
        String sql = "{call up_delhotel(?)}";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("驱动程序加载成功");
        String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String username = "root";
        String pwd = "123456";
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("数据库连接创建成功");
        CallableStatement ctmt = conn.prepareCall(sql);
        //为存储过程中的酒店ID设置实际ID值
        ctmt.setObject(1,94);
        ResultSet rs = ctmt.executeQuery();
        if(rs!=null && rs.next()){
            System.out.println("结果：" + rs.getObject(1));
        }
        rs.close(); ctmt.close(); conn.close();
    }
}
