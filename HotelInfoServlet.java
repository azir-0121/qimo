package controller;

import model.THotel;
import model.TRoomType;
import service.HotelService;
import service.HotelServiceImpl;
import service.RoomTypeService;
import service.RoomTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * 实现hotelinfo.jsp中酒店和房间类别信息的加载
 */
@WebServlet(name = "HotelInfoServlet", value = "/jspviews/hotelinfo.do")
public class HotelInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shotelid = request.getParameter("hotelid"); //获取名为hotelid的参数值
        int hotelid = 0;
        if(shotelid!=null){
            hotelid = Integer.parseInt(shotelid);
        }
        HotelService hser = new HotelServiceImpl();
        RoomTypeService rser = new RoomTypeServiceImpl();
        //获取酒店对象和酒店的房间类型对象集合
        THotel hotel = hser.getHotelById(hotelid);
        List<TRoomType> roomList = rser.getRoomTypeListByHotelid(hotelid);
        //out.println(roomList.size());
        request.setAttribute("hotel",hotel);
        request.setAttribute("roomList",roomList);
        RequestDispatcher rd = request.getRequestDispatcher("hotelinfo.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
