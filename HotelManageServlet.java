package controller;

import model.THotel;
import model.VUser;
import service.HotelService;
import service.HotelServiceImpl;
import utils.DispatcherUtils;
import utils.UserTypeProperties;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 打开hotelmanage.jsp前，加载管理员用户数据和查询所管理酒店数据的动作请求控制器
 */
@WebServlet(name = "HotelManageServlet", value = "/jspviews/hotelmanage.do")
public class HotelManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将根据用户登录用户，来获取企业信息，以及企业下面管理的酒店信息
        HttpSession session = request.getSession();
        VUser loginuser = (VUser)session.getAttribute("loginuser");
        if(loginuser==null || loginuser.getUtid()!= UserTypeProperties.HOTELADMINTYPE){
            DispatcherUtils.openErrWeb("您不是酒店管理员，或没有登录，无法打开此页面",
                    "index.do",request,response);
            return;
        }
        request.setAttribute("hoteladmin",loginuser);
        HotelService hserv = new HotelServiceImpl();
        List<THotel> hotelList = hserv.getHotelsByUser(loginuser.getUserid());
        request.setAttribute("hotelList",hotelList);
        DispatcherUtils.openWeb("hotelmanage.jsp",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
