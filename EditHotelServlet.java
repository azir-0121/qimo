package controller;

import model.THotel;
import service.HotelService;
import service.HotelServiceImpl;
import utils.DispatcherUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 打开edithotel.jsp前，根据用户输入的hotelid，实现加载酒店数据的动作请求控制器
 */
@WebServlet(name = "EditHotelServlet", value = "/jspviews/edithotel.do")
public class EditHotelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s_hotelid = request.getParameter("hotelid"); //来自菜单的请求参数
        if(s_hotelid==null ||s_hotelid.equals("")){
            THotel hotel = new THotel(); //用户意愿是添加一个酒店，因此创建一个空对象
            request.setAttribute("hotel",hotel);
        }else{  //用户要修改酒店信息
            int hotelid = Integer.parseInt(s_hotelid);
            HotelService hserv = new HotelServiceImpl();
            THotel hotel = hserv.getHotelById(hotelid); //查询要修改的酒店对象
            request.setAttribute("hotel",hotel);
        }
        DispatcherUtils.openWeb("edithotel.jsp",request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
