<%--
  showfruit.jsp
  接受servlet的请求，显示水果信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //从request对象中取得保存的值
    String favoritefruit = (String)request.getAttribute("favoritefruit");
    //从request对象中获取来自上一个页面的参数值
    String hatefruit = request.getParameter("hatefruit");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <center><h2>
        你最喜欢的水果是：<%=favoritefruit%> <br>
        你最讨厌的水果是：<%=hatefruit%>
    </h2></center>
</body>
</html>
