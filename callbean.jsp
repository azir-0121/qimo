<%--
  学习JSP页面指令-page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date,java.text.*"%>
<%@ page import="service.HotelService" %>
<%@ page import="service.HotelServiceImpl" %>
<%@ page import="model.THotel" %>
<html>
<head>
    <title>Title</title>
    <%
        Date date = new Date(); //获取当前时间的date对象
        SimpleDateFormat df = new SimpleDateFormat("y年M月d日 h:m:s EEEE");
        String fmtDate = df.format(date); //将date对象时间值格式化返回字符串
        //调用业务服务类，获取酒店信息
        HotelService hservice = new HotelServiceImpl();
        THotel hotel = hservice.getHotelById(17); //获取id=17的酒店对象
    %>
</head>
<body>
    学习JSP网页技术
    <br>
    <%out.print("当前学习的是JSP页面指令-page");%>
    <br>
    <h2>
        当前时间为：<%=fmtDate%>
        <br>
        酒店名称：<%=hotel.getHotelname()%> <br>
        酒店地址：<%=hotel.getProvince()%>.<%=hotel.getCity()%>.<%=hotel.getDetailaddr()%> <br>
        酒店特色：<%=hotel.getFeatures()%> <br>
        酒店服务：<%=hotel.getServer()%> <br>
        酒店服务电话：<%=hotel.getTels()%> <br>
    </h2>
</body>
</html>
