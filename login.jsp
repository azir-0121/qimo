<%--
  学习resposne对象实现登录的身份验证和响应
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<center>
    <h3>用户登录</h3>
    <form action="userconfirm.jsp" method="post">
        用户账户名称：<input type="text" name="userid"/> <br>
        用户登录密码：<input type="password" name="pwd"/> <br>
        <input type="submit" value="登录"/>
    </form>
</center>
</body>
</html>
