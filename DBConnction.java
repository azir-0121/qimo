package dbc;

import java.awt.geom.RectangularShape;
import java.sql.*;

/**
 * 数据库连接类，用于封装项目数据库的连接参数，向上一层提供数据库的连接操作
 * @Version 2025-9023
 * @author 张锦盛
 */
public class DBConnction {
    /**
     * 项目数据库JDBC驱动程序名称
     */
    private String driverName = "com.mysql.jdbc.Driver";
    /**
     * 连接项目目标数据库的URL地址
     */
    private String url = "jdbc:mysql://localhost:3306/hotelbookingdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    /**
     * 项目数据库的访问用户账号
     */
    private String username = "root";
    /**
     * 项目数据库访问用户的登录密码
     */
    private String pwd = "123456";

    /**
     * 使用DBConnecton类中定义的数据库参数创建目标数据库的连接对象
     * @return java.sql.Connection对象
     */
    public Connection getConnection() throws Exception{
        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url,username,pwd);
        System.out.println("数据库连接建立成功");
        return conn;
    }

    /**
     * 关闭数据库的资源，避免在使用完数据库后，数据库连接资源仍被占用
     * @param rs java.sql.ResultSet
     * @param stmt java.sql.Statement
     * @param conn java.sql.Connection
     */
    public void closeConnection(ResultSet rs, Statement stmt, Connection conn){
        try {
            if(rs!=null)
                rs.close();
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
            System.out.println("数据库资源关闭成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
