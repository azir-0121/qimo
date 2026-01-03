<%--
  学习reqeust,session,application的二个页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //从内置对象中取出数据
    String city = (String)request.getAttribute("city");
    String province = (String)session.getAttribute("province");
    String country = (String)application.getAttribute("counrty");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    ssessionid = <%=session.getId()%> <br>
    城市（存储在request中）：<%=city%> <br>
    省份（存储在session中）：<%=province%> <br>
    国家（存储在application中）：<%=country%> <br>
    <a href="sessiondemo1.jsp">跳转回sessiondemo1.jsp</a>
</h2>
</body>
</html>
