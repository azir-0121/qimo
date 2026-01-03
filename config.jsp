<%--
   学习JSP内置对象中的config对象，作用：用于读取web.mxl文件中的配置信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String databaseName = config.getInitParameter("databaseName");
    String databaseVersion = config.getInitParameter("databaseVersion");
    String driverName = config.getInitParameter("driverName");
%>
<html>
<head>
    <title>使用config对象读取配置信息</title>
</head>
<body>
    <%--使用JSP内置对象可以在JSP网页或者servlet中使用--%>
    <h2>
        获取来自web.xml文件中配置的数据库信息<br>
        数据库名称: <%=databaseName%> <br>
        数据库产品版本: <%=databaseVersion%><br>
        该数据的驱动程序名称: <%=driverName%><br>
    </h2>
</body>
</html>
