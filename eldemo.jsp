<%@ page import="service.HotelService" %>
<%@ page import="service.HotelServiceImpl" %>
<%@ page import="model.THotel" %>
<%@ page import="service.RoomTypeService" %>
<%@ page import="service.RoomTypeServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="model.TRoomType" %><%--
  学习el表达式
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    application.setAttribute("college","云南工商学院");
    session.setAttribute("department","人工智能学院");
    request.setAttribute("professional","软件工程");
    String clsname = "2022级软件工程1班";

    application.setAttribute("city","北京");
    session.setAttribute("city","昆明");
    //request.setAttribute("city","嵩明");

    String ary[] = {"比亚迪","小鹏","理想","小米"};
    request.setAttribute("cars",ary);

    HotelService hserv = new HotelServiceImpl();
    THotel hotel = hserv.getHotelById(17);
    request.setAttribute("hotel",hotel);

    RoomTypeService rserv = new RoomTypeServiceImpl();
    List<TRoomType> roomList = rserv.getRoomTypeListByHotelid(1);
    request.setAttribute("rooms",roomList);
%>
<html>
<head>
    <title>学习el表达式</title>
    <h3>
        -----------1. 使用el表达式实现算数，比较，逻辑，空值运算，并将结果输出--------<br>
        6-2 => ${6-2}<br>
        6*5 => ${6*5}<br>
        6>5 => ${6>5}<br>
        6>5 && 2*3==5 => ${6>5 && 2*3==5}<br>
        -----------2. 使用el表达式输出常量--------------------------------------<br>
        我的专业是${"软件工程"}专业<br>
        我的班级是${1}班 <br>
        -----------3. 使用el表达式输出变量，变量必须以键值对方式定义在request,session和appliation中---<br>
        我的学校：${college} <br>
        我所在的学院：${department} <br>
        我所学习的专业：${professional} <br>
        我的班级是: <%=clsname%> <br>
        -----------4. 使用el搜索变量的顺序：request>session>appliation---<br>
        我所在的城市是: ${city}<br>
        -----------5. 使用el表达式输出数组的值-----------------<br>
        新能源汽车品牌有：${cars[0]},${cars[1]},${cars[2]},${cars[3]},${cars[4]}<br>
        -----------6. 使用el表达式输出对象的值-----------------<br>
        酒店名称:${hotel.hotelname}<br>  <%--el输出对象的属性，实际是调用对象的get方法--%>
        <img src="/upload/${hotel.photourl}" style="width: 180px; height: 120px"/> <br>
        地址：${hotel.province}.${hotel.city}.${hotel.detailaddr}<br>
        酒店特色：${hotel.features} <br>
        配套服务：${hotel.server} <br>
        酒店电话：${hotel.tels} <br>
        -----------7. 使用el表达式输出存储对象的集合信息-----------------<br>
        <img src="/upload/${rooms[0].photourl}" style="width: 180px; height: 120px"/>
        ${rooms[0].roomtype} &nbsp;&nbsp;
        ${rooms[0].bedtype} &nbsp;&nbsp;
        ${rooms[0].price}
        <br><hr>
        <img src="/upload/${rooms[1].photourl}" style="width: 180px; height: 120px"/>
        ${rooms[1].roomtype} &nbsp;&nbsp;
        ${rooms[1].bedtype} &nbsp;&nbsp;
        ${rooms[1].price}
        <br><hr>
        <img src="/upload/${rooms[2].photourl}" style="width: 180px; height: 120px"/>
        ${rooms[2].roomtype} &nbsp;&nbsp;
        ${rooms[2].bedtype} &nbsp;&nbsp;
        ${rooms[2].price}
        <br><hr>

    </h3>

</head>
<body>

</body>
</html>
