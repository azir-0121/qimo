<%@ page import="service.HotelService" %>
<%@ page import="service.HotelServiceImpl" %>
<%@ page import="model.THotel" %>
<%@ page import="java.util.List" %>
<%--
  学习for循环实现网页内容的动态控制
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        HotelService hservice = new HotelServiceImpl();
        List<THotel> list = hservice.getHotelsByNameAndCity("昆明",null);
    %>
</head>
<body>
<center>
    <h3>
        <table border="1">
            <%
                for(THotel h: list){
            %>
                <tr>
                    <td><%=h.getHotelname()%></td>
                    <td><%=h.getProvince()%>.<%=h.getCity()%>.<%=h.getDetailaddr()%></td>
                    <td><%=h.getFeatures()%></td>
                    <td><%=h.getServer()%></td>
                    <td><%=h.getTels()%></td>
                </tr>
            <%
                }
            %>
        </table>
    </h3>
</center>
</body>
</html>
