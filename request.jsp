<%--
  学习JSP内置对象（request和response)
  该页面用于学习使用request内置对象来接收用户的请求
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //所有的jsp内置对象都要在脚本段中才能使用
    request.setCharacterEncoding("utf-8");
    String userid1 = request.getParameter("userid1"); //接收请求方的名为userid1的参数的值
    String pwd1 = request.getParameter("pwd1");
    String userid2 = request.getParameter("userid2"); //接收请求方的名为userid2的参数的值
    String pwd2 = request.getParameter("pwd2");
    //获取客户端主机的信息
    String remoteHost  = request.getRemoteHost(); //获取客户机主机名称
    String remoteAddr = request.getRemoteAddr(); //获取客户机主机网址
    int remotePort = request.getRemotePort(); //获取客户机请求使用的端口号
    String requestURL = request.getServletPath(); //获取请求的页面路径url

%>
<html>
<head>
    <title>接收请求页面</title>
</head>
<body>
    userid1 = <%=userid1%>  , pwd1 = <%=pwd1%> <br>
    userid2 = <%=userid2%>  , pwd2 = <%=pwd2%> <br>
    客户机主机名称: <%=remoteHost%> <br>
    客户机主机网址: <%=remoteAddr%> <br>
    客户机请求使用的端口号: <%=remotePort%> <br>
    请求的页面路径url: <%=requestURL%> <br>

</body>
</html>
