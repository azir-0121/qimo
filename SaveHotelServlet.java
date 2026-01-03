package controller;

import model.THotel;
import model.VUser;
import service.HotelService;
import service.HotelServiceImpl;
import utils.DispatcherUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 实现酒店信息保存的请求动作控制器
 * 酒店保存有两种状态：
 * （1）添加酒店， hotelid==0
 * (2)修改酒店，hotelid!=0
 */
@WebServlet(name = "SaveHotelServlet", value = "/jspviews/savehotel.do")
public class SaveHotelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收来自edithotel.jsp中表单参数
        request.setCharacterEncoding("utf-8"); //保证中文正确编码
        String s_hotelid = request.getParameter("hotelid");
        String hotelname = request.getParameter("hotelname");
        String country = request.getParameter("country");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String detailaddr = request.getParameter("detailaddr");
        String features = request.getParameter("features");
        String server = request.getParameter("server");
        String tels = request.getParameter("tels");
        String photourl = request.getParameter("photourl");
        //做数据校验
        if(hotelname==null || hotelname.equals("")){
            DispatcherUtils.openErrWeb("酒店名称不能为空",
                    "edithotel.do?hotelid="+s_hotelid,request,response);
            return;
        }
        //实现酒店信息的保存，注意要根据hotelid来判断是添加还是修改
        HotelService hserv = new HotelServiceImpl();
        HttpSession session = request.getSession();
        VUser loginuser = (VUser) session.getAttribute("loginuser");
        int hotelid = Integer.parseInt(s_hotelid) ;
        if(hotelid==0){
            //添加酒店
            THotel hotel = new THotel();
            hotel.setHotelname(hotelname);
            hotel.setCountry(country);
            hotel.setProvince(province);
            hotel.setCity(city);
            hotel.setDetailaddr(detailaddr);
            hotel.setFeatures(features);
            hotel.setServer(server);
            hotel.setTels(tels);
            hotel.setPhotourl(photourl);
            hotel.setUserid(loginuser.getUserid());
            if(hserv.addHotel(hotel)>0){
                //添加成功，返回酒店管理页面
                DispatcherUtils.openWeb("hotelmanage.do",request,response);
                return;
            }else{
                DispatcherUtils.openErrWeb("酒店信息添加失败，请联系管理员",
                        "edithotel.do?hotelid="+hotelid,request,response);
                return;
            }
        }else{
            //修改酒店，先查再改
            THotel hotel = hserv.getHotelById(hotelid);
            hotel.setHotelname(hotelname);
            hotel.setCountry(country);
            hotel.setProvince(province);
            hotel.setCity(city);
            hotel.setDetailaddr(detailaddr);
            hotel.setFeatures(features);
            hotel.setServer(server);
            hotel.setTels(tels);
            hotel.setPhotourl(photourl);
            //hotel.setUserid(loginuser.getUserid());
            if(hserv.modifyHotel(hotel)==true){
                //酒店修改成功
                response.sendRedirect("hotelinfo.do?hotelid="+hotelid);
                return;
            }else{
                //酒店修改失败
                DispatcherUtils.openErrWeb("酒店信息修改失败，请联系管理员",
                        "edithotel.do?hotelid="+hotelid,request,response);
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
