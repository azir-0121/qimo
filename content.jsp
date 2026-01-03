<%@ page import="service.HotelService" %>
<%@ page import="service.HotelServiceImpl" %>
<%@ page import="model.THotel" %>
<%@ page import="java.util.List" %>
<%--
  内容页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内容页面</title>
    <%
        HotelService hservice = new HotelServiceImpl();
        List<THotel> hotellist = hservice.getHotelsByNameAndCity("昆明","桔子");
        //out.print(hotellist.size());
    %>
</head>
<body>
    <center>
        <h3>
            <table border="1">
                <%
                    for(THotel h: hotellist){
                        out.print("<tr>" +
                                "<td>"+h.getHotelname()+"</td>" +
                                "<td>"+h.getCity()+"</td>" +
                                "</tr>");
                    }
                %>
            </table>
        </h3>
    </center>
</body>
</html>
