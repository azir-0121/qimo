<%@ page import="service.UserServiceImpl" %>
<%@ page import="service.UserService" %>
<%@ page import="model.VUser" %><%--
  学习jsp request和response对象
  该页面实现用户登录信息的接收，用户身份的验证，以及做出响应
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userid = request.getParameter("userid");
    String pwd = request.getParameter("pwd");
    UserService userv = new UserServiceImpl();
    VUser loginuser = userv.login(userid,pwd);
    if(loginuser!=null && loginuser.getUserid()!=null){
        response.sendRedirect("success.jsp"); //使用response响应对象来实现用户请求的响应动作
    }else{
        response.sendRedirect("failure.jsp");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
</body>
</html>
