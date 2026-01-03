<%--
  Created by IntelliJ IDEA.
  User: OK
  Date: 2025/11/6
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学习变量的定义和输出</title>
    <script>
        var stuid2 = "02259270633"  //不需要;结束
    </script>
</head>
<body>
    <%
        String stuid = "02259270633";
        String stuname = "李海涛";
        int age = 21;
    %>
    <center>
        <table border="1">
            <tr>
                <td><%out.print(stuid); %></td>
                <td><%out.print(stuname);%></td>
                <td><%out.print(age); %></td>
            </tr>
            <tr>
                <td><%=stuid2%></td>  <%--使用表达式，不要跟;--%>
                <td><%=stuname2%></td>
                <td><%=age2%></td>
            </tr>
        </table>
    </center>
    <%--脚本标签中加入！可以将变量变为全局变量。--%>
    <%!
        String stuid2 = "02259270343";
        String stuname2 = "李华";
        int age2 = 21;
    %>
</body>
</html>
