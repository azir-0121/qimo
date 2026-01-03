package service;

import dao.UserDAO;
import dao.UserDaoImpl;
import model.TUser;
import model.VUser;
import utils.UserTypeProperties;

import javax.swing.*;
import java.util.List;

/**
 * 用户管理功能模块实现类
 */
public class UserServiceImpl implements UserService{
    private UserDAO udao = new UserDaoImpl();
    //private HotelDAO hdao = new HotelDaoImpl(); //根据需要来创建使用的DAO对象
    @Override
    public VUser login(String userid, String pwd) {
        VUser user = new VUser();
        user.setUserid(userid);
        user.setPwd(pwd);
        List<VUser> list = udao.selectBySelective(user);
        if(list.size()>0) return list.get(0);
        else return null;
    }

    @Override
    public boolean isUseridValid(String userid) {
        TUser user = udao.selectTUserByPrimaryKey(userid);
        if(user==null || user.getUserid()==null){
            return true;  //数据库查不出来，该userid可用，返回true
        } else {
            return false;
        }
    }

    @Override
    public boolean registerUser(TUser user) {
        //调用UserDAO中insert()
        int rows = udao.insert(user);
        if(rows>0) return true;
        else return false;
    }

    @Override
    public boolean modifyUser(TUser user) {
        //调用UserDAO的update()
        int rows = udao.update(user);
        if(rows>0) return true;
        else return false;
    }

    @Override
    public TUser getTUserByid(String userid) {
        //调用UserDAO的selectTUserByPrimaryKey()
        return udao.selectTUserByPrimaryKey(userid);
    }

    @Override
    public VUser getVUserByid(String userid) {
        //调用UserDAO的selectVUserByPrimaryKey()
        return udao.selectVUserByPrimaryKey(userid);
    }

    @Override
    public boolean isHotelUser(String userid) {
        //调用UserDAO的selectTUserByPrimaryKey()
        TUser user = udao.selectTUserByPrimaryKey(userid);
        if(user!=null && user.getUtid()== UserTypeProperties.HOTELADMINTYPE)
            return true;
        else
            return false;
    }
}
