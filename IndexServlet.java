package controller;

import model.THotel;
import service.HotelService;
import service.HotelServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 实现index.jsp主页中所有酒店数据的加载和查询
 */
@WebServlet(name = "IndexServlet", value = "/jspviews/index.do")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = null;
        String hotelname = null;
        request.setCharacterEncoding("utf-8");
        //接受参数
        city = request.getParameter("city");
        hotelname = request.getParameter("hotelname");
        HotelService hserv = new HotelServiceImpl(); //创建酒店业务类对象
        List<THotel> hotelList = hserv.getHotelsByNameAndCity(city, hotelname);
        //out.println(hotelList.size()); //显示集合中有多少条记录
        request.setAttribute("hotelList",hotelList);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
