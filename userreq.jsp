<%--
  学习JSP内置对象（request和response)
  该页面用于模拟用户的请求
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户的请求页面</title>
</head>
<body>
    <%--a标签的网页请求方式为get请求，该方式的特点：请求参数会出现在浏览器的地址栏中--%>
    <a href="request.jsp?userid1=张锦盛&pwd1=123456">请求request.jsp网页</a>
    <br><br>
    <form action="request.jsp" method="post">
        用户账户名称：<input type="text" name="userid2"/> <br>
        用户登录密码：<input type="password" name="pwd2"/> <br>
        <input type="submit" value="提交表单数据到request.jsp"/>
    </form>
</body>
</html>
