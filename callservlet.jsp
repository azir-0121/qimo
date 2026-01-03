<%--
  callservlet.jsp
  请求servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求servlet</title>
</head>
<body>
    -----使用get请求方式请求FirstServlet--------<br>
    <a href="first.do?pome=万条垂下绿丝绦">请求FirstServlet</a>
    <br><br>
    -----使用post请求方式请求FirstServlet-------<br>
    <form action="first.do" method="post">
        我要说：<input type="text" name="pome"/> <br>
        <input type="submit" value="请求FirstServlet"/>
    </form>
</body>
</html>
