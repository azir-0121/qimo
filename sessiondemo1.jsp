<%--
  我们来学习reqeust,session和application
  request对象可以作为页面自己的容器
  session对象可以作为会话期间的容器
  applicaton对象可以作为整个应用在服务器运行期间的容器
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //我们可以修改session的存活时间，当浏览器关闭后他存活时间
    session.setMaxInactiveInterval(1000*60);  //浏览器关闭后1分钟内，session不会被销毁
    //把数据存到内置对象中
    request.setAttribute("city","昆明");
    session.setAttribute("province","云南");
    application.setAttribute("counrty","中国");
    //从内置对象中取出数据
    String city = (String)request.getAttribute("city");
    String province = (String)session.getAttribute("province");
    String country = (String)application.getAttribute("counrty");
%>
<%%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>
        城市（存储在request中）：<%=city%> <br>
        省份（存储在session中）：<%=province%> <br>
        国家（存储在application中）：<%=country%> <br>
    </h2>
    <a href="sessiondemo2.jsp">跳转到sessiondemo2.jsp</a>
</body>
</html>
