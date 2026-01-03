package controller;

import model.TUser;
import service.UserService;
import service.UserServiceImpl;
import utils.DispatcherUtils;
import utils.UserTypeProperties;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 酒店管理员（会员）注册请求动作控制器
 */
@WebServlet(name = "AddHotelMemberServlet", value = "/jspviews/addhotelmember.do")
public class AddHotelMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收注册参数
        request.setCharacterEncoding("utf-8");
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String pwd2 = request.getParameter("pwd2");
        String mobile = request.getParameter("mobile");
        String mail = request.getParameter("mail");
        String companyname = request.getParameter("companyname");
        //数据校验
        if(userid==null ||userid.equals("")){
            DispatcherUtils.openErrWeb("注册用户账号不能为空",
                    "addhotelmember.jsp",request,response);
            return;
        }else if(username==null ||username.equals("")){
            DispatcherUtils.openErrWeb("注册用户名不能为空",
                    "addhotelmember.jsp",request,response);
            return;
        }else if(pwd==null ||pwd.equals("")){
            DispatcherUtils.openErrWeb("注册用户登录密码不能为空",
                    "addhotelmember.jsp",request,response);
            return;
        }else if(pwd2==null ||pwd2.equals("")){
            DispatcherUtils.openErrWeb("注册用户登录密码再次确认不能为空",
                    "addhotelmember.jsp",request,response);
            return;
        }else if(!pwd.equals(pwd2)){
            DispatcherUtils.openErrWeb("注册登录密码与密码确认不一致",
                    "addhotelmember.jsp",request,response);
            return;
        }
        //调用业务类实现管理员用户的注册
        UserService userv = new UserServiceImpl();
        TUser user = new TUser();
        user.setUserid(userid);  //将用户填写的用户信息放入到实体对象中
        user.setUsername(username);
        user.setPwd(pwd);
        user.setUtid(UserTypeProperties.HOTELADMINTYPE);
        user.setMobile(mobile);
        user.setMail(mail);
        user.setCompanyname(companyname);
        //判断用户注册的账号可用
        if(!userv.isUseridValid(userid)){
            DispatcherUtils.openErrWeb("当前注册用户账号已经存在，请重新输入新的账号",
                    "addhotelmember.jsp",request,response);
            return;
        }
        if(userv.registerUser(user)){
            //注册成功
            response.sendRedirect("login.jsp");
        }else{
            DispatcherUtils.openErrWeb("管理员注册失败，请联系系统管理员",
                    "addhotelmember.jsp",request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
