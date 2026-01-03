package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于保存来自v_user视图的查询数据
 */
public class VUser {
    private String userid;
    private String username;
    private int utid;
    private String pwd;
    private String mobile;
    private String mail;
    private String companyname;
    private String licencephoto;
    private String createtime;
    private String utname;
    //无参构造方法
    public VUser() {
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

    public String getUtname() {
        return utname;
    }

    public void setUtname(String utname) {
        this.utname = utname;
    }

    @Override
    public String toString() {
        return "VUser{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", utid=" + utid +
                ", pwd='" + pwd + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                ", companyname='" + companyname + '\'' +
                ", licencephoto='" + licencephoto + '\'' +
                ", createtime='" + createtime + '\'' +
                ", utname='" + utname + '\'' +
                '}' +"\n";
    }

    //用于交换结果集单条数据的构造方法
    public VUser(ResultSet rs){
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
                this.setUtname(rs.getString("utname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //用于交换结果集多条数据的静态tranList方法
    public static List<VUser> tranList(ResultSet rs){
        List<VUser> list = new ArrayList<VUser>();
        try{
            while(rs!=null && rs.next()){
                VUser user = new VUser();
                user.setUserid(rs.getString("userid"));
                user.setUsername(rs.getString("username"));
                user.setUtid(rs.getInt("utid"));
                user.setPwd(rs.getString("pwd"));
                user.setMobile(rs.getString("mobile"));
                user.setMail(rs.getString("mail"));
                user.setCompanyname(rs.getString("companyname"));
                user.setLicencephoto(rs.getString("licencephoto"));
                user.setCreatetime(rs.getString("createtime"));
                user.setUtname(rs.getString("utname"));
                list.add(user); //每次获得一个新的有值的user对象，就将对象添加到list集合中
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
