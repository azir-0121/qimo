package controller;

import model.VUser;
import service.HotelService;
import service.HotelServiceImpl;
import utils.DispatcherUtils;
import utils.UserTypeProperties;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 删除酒店及其客房信息的动作请求控制器
 */
@WebServlet(name = "DeleteHotelServlet", value = "/jspviews/deletehotel.do")
public class DeleteHotelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除酒店必须获得被删除酒店的hotelid
        int hotelid = Integer.parseInt(request.getParameter("hotelid"));
        //查询删除权限，必须是酒店管理员
        HttpSession session = request.getSession();
        VUser loginuser = (VUser)session.getAttribute("loginuser");
        if(loginuser==null ||loginuser.getUtid()!= UserTypeProperties.HOTELADMINTYPE){
            DispatcherUtils.openErrWeb("您不是管理员，无权删除酒店",
                    "hotelinfo.do?hotelid="+hotelid,request,response);
            return;
        }

        HotelService hserv = new HotelServiceImpl();
        if(hserv.removeHotel(hotelid)==true){
            response.sendRedirect("hotelmanage.do");
            return;
        }else{
            DispatcherUtils.openErrWeb("删除酒店失败，可能是该酒店客房已经有人预定",
                    "hotelinfo.do?hotelid="+hotelid,request,response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
