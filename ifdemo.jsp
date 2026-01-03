<%--
  Created by IntelliJ IDEA.
  User: OK
  Date: 2025/11/13
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        //获取来自URL地址中的type参数的值
        String type = request.getParameter("type");
    %>
</head>
<body>
    <ul style="width:100%;height: 50px;background-color: cornflowerblue;
    padding-top: 10px; list-style-type: none">
    <%   //使用if语句来控制ul中的li（列表项）
        if(type!=null && type.equals("news")){
    %>
        <li style="width: 200px; padding-right: 5px; float: right">国内新闻</li>
        <li style="width: 200px; padding-right: 5px; float: right">国际新闻</li>
    <% }else if(type!=null && type.equals("sports")){ %>
        <li style="width: 200px; padding-right: 5px; float: right">中超</li>
        <li style="width: 200px; padding-right: 5px; float: right">CBA</li>
    <% }else{ %>
        <li style="width: 500px; padding-right: 5px; float: right">您的选择操作有误</li>
    <% } %>
    </ul>
</body>
</html>
