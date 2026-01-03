package controller;

import model.VUser;
import service.UserService;
import service.UserServiceImpl;
import utils.DispatcherUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 实现用户登录请求动作业务逻辑的控制器
 */
@WebServlet(name = "LoginServlet", value = "/jspviews/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        request.setCharacterEncoding("utf-8");
        String userid = request.getParameter("userid");
        String pwd = request.getParameter("pwd");
        //数据校验
        if(userid==null || userid.equals("")){
            DispatcherUtils.openErrWeb("登录账号不能为空","login.jsp",request,response);
            return;
        }else if(pwd==null || pwd.equals("")){
            DispatcherUtils.openErrWeb("登录密码不能为空","login.jsp",request,response);
            return;
        }
        //身份验证（完成页面的跳转）
        UserService userv = new UserServiceImpl();
        VUser loginuser = userv.login(userid,pwd);
        if(loginuser!=null && loginuser.getUserid()!=null){
            HttpSession session = request.getSession();
            session.setAttribute("loginuser",loginuser); //将登录用户对象保存到session
            response.sendRedirect("index.do"); //成功直接跳转回主页
        }else{
            DispatcherUtils.openErrWeb("您输入的用户账号和密码不正确",
                    "login.jsp",request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
