package dao;

import dbc.DBConnction;

import javax.naming.ldap.PagedResultsControl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据访问工具类
 */
public class BaseDAO extends DBConnction implements IBaseDAO {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private CallableStatement ctmt = null;
    private ResultSet rs = null;

    @Override
    public void close() {
        if(ctmt==null)
            this.closeConnection(rs,ptmt,conn);
        else
            this.closeConnection(rs,ctmt,conn);
    }

    @Override
    public int insert(String sql, Object[] para) {
        int rows = 0, keys = 0; //主键ID的值
        try {
            conn = this.getConnection();
            ptmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            for(int i=1;para!=null && i<=para.length;i++){
                ptmt.setObject(i,para[i-1]); //SQL命令中的?位置从1开始，数组索引从0开始
            }
            rows = ptmt.executeUpdate();
            if(rows>0){
               rs = ptmt.getGeneratedKeys(); //获得存储有主键ID值的ResultSet
               if(rs!=null && rs.next()){
                   keys = rs.getInt(1);
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.close(); //关闭数据库资源
        if(keys>0 ) return keys;
        else return rows;
    }

    @Override
    public int update(String sql, Object[] para) {
        int rows = 0;
        try {
            conn = this.getConnection();
            ptmt = conn.prepareStatement(sql);
            for(int i=1;para!=null && i<=para.length;i++){
                ptmt.setObject(i,para[i-1]);
            }
            rows = ptmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.close(); //关闭数据库的资源
        return rows;  //返回数据库表数据受影响的行数
    }

    @Override
    public int delete(String sql, Object[] para) {
        int rows = 0;
        try {
            conn = this.getConnection();
            ptmt = conn.prepareStatement(sql);
            for(int i=1;para!=null && i<=para.length;i++){
                ptmt.setObject(i,para[i-1]);
            }
            rows = ptmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.close(); //关闭数据库的资源
        return rows;  //返回数据库表数据受影响的行数
    }

    @Override
    public ResultSet select(String sql, Object[] para) {
        try {
            conn = this.getConnection();
            ptmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            for(int i=1;para!=null && i<=para.length;i++){
                ptmt.setObject(i,para[i-1]);
            }
            rs = ptmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //this.close(); //不能关闭资源，因为一旦关闭资源 ResultSet就会别销毁，同时查询的数据也丢失
        return rs;
    }

    @Override
    public int selectCount(String sql, Object[] para) {
        int rowCount = 0; //记录数
        try {
            conn = this.getConnection();
            ptmt = conn.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            for(int i=1; para!=null && i<=para.length;i++){
                ptmt.setObject(i,para[i-1]);
            }
            rs = ptmt.executeQuery();
            rs.last(); //跳到最后一行
            rowCount = rs.getRow(); //最后一行的行号就是记录总数
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.close(); //关闭数据库资源
        return rowCount;
    }

    @Override
    public ResultSet callProcedureWithQuery(String procName, Object[] para) {
        try {
            conn = this.getConnection();
            ctmt = conn.prepareCall("{ call "+ procName +"}");
            for(int i=1; para!=null && i<=para.length; i++){
                ctmt.setObject(i,para[i-1]);
            }
            rs = ctmt.executeQuery();  //因为存储过程中返回结果使用的是select 0,  select 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //this.close();
        return rs;
    }
}
