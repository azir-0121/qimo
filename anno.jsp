<%--
  学习JSP中的三种注释
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP的三种注释</title>
</head>
<body>
    <!--html注释，该注释不被JVM所编译，在网页中不可见，但在网页源代码中可见-->

    <%-- jsp的全段注释，该注释被JVM所编译，但会被忽略，在网页中不可见，
         在网页源代码中也不可见
      int a = 10;
      out.println("hello world");
    --%>

    <%
        //jsp的java脚本注释，该注释会被JVM所编译，但会被忽略，在网页中不可见，
        //在网页源代码中也不可见
        //String name = "张三";

        /*out.println(name);*/
    %>
</body>
</html>
