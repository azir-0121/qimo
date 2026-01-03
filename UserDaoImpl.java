package temp;

import dao.BaseDAO;
import dao.IBaseDAO;
import model.TUser;
import model.VUser;

import java.sql.ResultSet;
import java.util.List;

/**
 * 继承和实现UserDAO接口的用户数据访问类
 */
public class UserDaoImpl implements UserDAO{
    private IBaseDAO bdao =new BaseDAO();

    @Override
    public int insert(TUser record) {
        String sql = "insert into t_user(userid,username,utid,pwd,mobile," +
                "mail,companyname,licencephoto) values(?,?,?,?,?,?,?,?)";
        Object[] para = {record.getUserid(),record.getUsername(),record.getUtid(),
            record.getPwd(),record.getMobile(), record.getMail(),
            record.getCompanyname(),record.getLicencephoto()};
        int rows = bdao.insert(sql,para);
        return rows;
    }

    @Override
    public int update(TUser record) {
        String sql = "update t_user set username=?,pwd=?,mobile=?,mail=?," +
                "companyname=?,licencephoto=? where userid=?";
        Object[] para = {record.getUsername(),record.getPwd(),
                record.getMobile(),record.getMail(),record.getCompanyname(),
                record.getLicencephoto(),record.getUserid()};
        int rows = bdao.update(sql,para);
        return rows;
    }

    @Override
    public int deleteByPrimaryKey(String userid) {
        String sql = "delete from t_user where userid =?";
        Object[] para = {userid};
        int rows = bdao.delete(sql,para);
        return rows;
    }

    @Override
    public TUser selectTUserByPrimaryKey(String userid) {
        String sql = "select * from t_user where userid = ?";
        Object[] para = {userid};
        ResultSet rs = bdao.select(sql,para);
        TUser user = new TUser(rs);
        bdao.close();
        return user;
    }

    @Override
    public VUser selectVUserByPrimaryKey(String userid) {
        String sql = "select * from v_user where userid = ?";
        Object[] para = {userid};
        ResultSet rs = bdao.select(sql,para);
        VUser user = new VUser(rs);
        bdao.close();
        return user;
    }

    @Override
    public List<VUser> selectBySelective(VUser record) {
        return null;
    }
}
