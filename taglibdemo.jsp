<%--
  学习taglib指令，在此网页中，我们将引入JSTL标签库
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学习taglib指令</title>
</head>
<body>
    <c:out value="我是JSTL中的out标签，用于输出变量，常量和表达式的值"></c:out>
</body>
</html>
