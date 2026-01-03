package dao;

import java.sql.ResultSet;

/**
 * 数据库访问操作接口
 * @author  zjs
 */
public interface IBaseDAO {
	/**
	 * 该方法提供数据库java.sql.Connection,java.sql.Statement,java.sql.ResultSet等操作资源的关闭
	 * @return void
	 */
	public void close();

	/**
	 * 提供数据库表记录的插入操作
	 * 案例：String sql = "insert into t_hotel(hotelname,userid) values(?,?)";
	 *      Object[] para = {"测试酒店名称","测试管理员用户"};
	 *      int rowsOrKey = insert(sql,para);
	 *@ param sql,  提供表记录插入的用户insert into的SQL语句
	 *@ param para , 当SQL中有'?'参数时，para数组提供对应参数的所有值
	 *@ return int, 当主键不是自动编号时，返回的是数据库受影响的行数，如成功返回>0,失败为0
	 * 否则，返回系统分配给新记录的主键值
	 */
	public int insert(String sql,Object[] para);
	
	/**
	 * 提供数据库表记录的更新操作
	 * 案例：String sql = "update t_hotel set detailaddr = ? where hotelid = ?";
	 *      Object[] para = {"测试酒店的详细地址","测试酒店的ID"};
	 *      int rows = update(sql,para);
	 * @param sql,  提供表记录更新的用户update set的SQL语句
	 * @param para, 当SQL中有'?'参数时，para数组提供对应参数的所有值
	 * @return int,  返回的是数据库中受影响的行数，即成功返回>0,失败为0
	 */
	public int update(String sql,Object[] para);

	/**
	 * 提供数据库表记录的删除操作
	 * 案例：String sql = "delete from t_hotel where hotelid = ?";
	 *      Object[] para = {"测试酒店的ID"};
	 *      int rows = delete(sql,para);
	 * @param sql,  提供表记录删除的用户delete from的SQL语句
	 * @param para, 当SQL中有'?'参数时，para数组提供对应参数的所有值
	 * @return int,  成功返回>0,失败为0
	 */
	public int delete(String sql,Object[] para);
	
	/**
	 * 提供表记录查询操作
	 * 案例：String sql = "select * from t_hotel";
	 *      ResultSet rs  = select(sql,null);
	 * @param sql,  提供表记录查询的用户select from的SQL语句
	 * @param para, 当SQL中有'?'参数时，para数组提供对应参数的所有值
	 * @return ResultSet  调用后需调用接口的close()方法关闭资源
	 */
	public ResultSet select(String sql,Object[] para);

	/**
	 * 提供表记录查询操作，与select()不同的是返回的仅仅是查出记录的总数
	 * 案例：String sql = "select * from t_hotel";
	 *      int rowCount = selectCount(sql,null);
	 * @param sql,  提供表记录查询的用户select from的SQL语句
	 * @param para, 当SQL中有'?'参数时，para数组提供对应参数的所有值
	 * @return int  记录数
	 */
	public int selectCount(String sql,Object[] para);

	/**
	 * 提供调用存储过程的数据库操作，该方法仅提供执行返回select的存储过程
	 * 案例：String procName = "up_delhotel(?)";
	 *      Object[] para = {"删除测试酒店的ID"};
	 *      ResultSet rs = callProcedureWithQuery(procName,para);
	 * @param procName  存储过程的名称
	 * @param para, 当存储过程方法中有'?'参数时，para数组提供对应参数的所有值
	 * @return ResultSet
	 */
	public ResultSet callProcedureWithQuery(String procName, Object[] para);
}
