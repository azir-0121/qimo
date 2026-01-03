package temp;

import model.TUser;
import model.VUser;
import org.junit.Test;

public class UserDaoImplTest {
    private UserDAO udao = new UserDaoImpl();

    @Test
    public void insert() {
        TUser user = new TUser();
        user.setUserid("lism");
        user.setUsername("李世民");
        user.setUtid(2);
        user.setPwd("666666");
        int rowsOrKey = udao.insert(user);
        System.out.println("rowsOrKdy=" + rowsOrKey);
    }

    @Test
    public void update() {
        TUser user = udao.selectTUserByPrimaryKey("lism"); //先查
        user.setPwd("123456");
        user.setMobile("13900000009");
        user.setMail("00009@qq.com");
        int rows = udao.update(user);
        System.out.println("rows=" + rows + ",修改后："
                + udao.selectTUserByPrimaryKey("lism"));
    }

    @Test
    public void deleteByPrimaryKey() {
        int rows = udao.deleteByPrimaryKey("lism");
        System.out.println("rows=" + rows + ",修改后："
                + udao.selectTUserByPrimaryKey("lism"));
    }

    @Test
    public void selectTUserByPrimaryKey() {
        TUser user = udao.selectTUserByPrimaryKey("lism");
        System.out.println(user);
    }

    @Test
    public void selectVUserByPrimaryKey() {
        VUser user = udao.selectVUserByPrimaryKey("lism");
        System.out.println(user);
    }

    @Test
    public void selectBySelective() {
    }
}