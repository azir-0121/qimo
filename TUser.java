package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于交换来自t_user表的瞬时数据的实体类
 */
public class TUser {
    private String userid;
    private String username;
    private int utid;
    private String pwd;
    private String mobile;
    private String mail;
    private String companyname;
    private String licencephoto;
    private String createtime;

    public TUser() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUtid() {
        return utid;
    }

    public void setUtid(int utid) {
        this.utid = utid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getLicencephoto() {
        return licencephoto;
    }

    public void setLicencephoto(String licencephoto) {
        this.licencephoto = licencephoto;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    //实现结果集中单条用户数据交换到单个TUser对象的方法
    public TUser(ResultSet rs){
        try {
            if (rs != null && rs.next()) {
                this.setUserid(rs.getString("userid"));
                this.setUsername(rs.getString("username"));
                this.setUtid(rs.getInt("utid"));
                this.setPwd(rs.getString("pwd"));
                this.setMobile(rs.getString("mobile"));
                this.setMail(rs.getString("mail"));
                this.setCompanyname(rs.getString("companyname"));
                this.setLicencephoto(rs.getString("licencephoto"));
                this.setCreatetime(rs.getString("createtime"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //实现结果集中多条用户记录交换到List<TUser>集合中的方法
    public static List<TUser> tranList(ResultSet rs){
        List<TUser> list = new ArrayList<TUser>();
        try{
            while(rs!=null && rs.next()){
                TUser user = new TUser();
                user.setUserid(rs.getString("userid"));
                user.setUsername(rs.getString("username"));
                user.setUtid(rs.getInt("utid"));
                user.setPwd(rs.getString("pwd"));
                user.setMobile(rs.getString("mobile"));
                user.setMail(rs.getString("mail"));
                user.setCompanyname(rs.getString("companyname"));
                user.setLicencephoto(rs.getString("licencephoto"));
                user.setCreatetime(rs.getString("createtime"));
                list.add(user); //每次获得一个新的有值的user对象，就将对象添加到list集合中
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", utid=" + utid +
                ", pwd='" + pwd + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                ", companyname='" + companyname + '\'' +
                ", licencephoto='" + licencephoto + '\'' +
                ", createtime='" + createtime + '\'' +
                '}' + "\n";
    }
}
