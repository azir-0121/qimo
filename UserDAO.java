package temp;

import model.TUser;
import model.VUser;

import java.util.List;

/**
 * 定义面向t_user和v_user的用户数据访问接口
 */
public interface UserDAO {
    /**
     * 将record实体对象中的用户数据插入到t_user表中保存
     * @param record TUser
     * @return int 如果主键是自动编号，则返回自动编号，否则返回受影响行数
     */
    public int insert(TUser record);

    /**
     * 将record实体对象中的用户数据更新到指定t_user表的记录中
     * @param record TUser
     * @return int 返回受影响行数
     */
    public int update(TUser record);

    /**
     * 完成将t_user表中匹配userid的用户记录删除
     * @param userid String
     * @return int 返回受影响行数
     */
    public int deleteByPrimaryKey(String userid);

    /**
     * 查询t_user表，并返回匹配userid的TUser对象
     * @param userid
     * @return TUser
     */
    public TUser selectTUserByPrimaryKey(String userid);

    /**
     * 查询v_user视图，并返回匹配userid的VUser对象
     * @param userid
     * @return VUser
     */
    public VUser selectVUserByPrimaryKey(String userid);

    /**
     * 基于record中提供的非null字段的值，实现v_user表的动态查询
     * @param record VUser
     * @return List<VUser>
     */
    public List<VUser> selectBySelective(VUser record);

}
