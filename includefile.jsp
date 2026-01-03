<%--
  学习include指令
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学习include指令</title>
</head>
<body>
    <!--包含sysmenu.jsp网页内容-->
    <%@ include file="sysmenu.jsp"%>
    <!--包含content.jsp网页内容-->
    <%@ include file="content.jsp"%>
</body>
</html>
