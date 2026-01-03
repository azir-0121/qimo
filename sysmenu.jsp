<%--
  学习JSP指令-include，先做一个菜单页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统菜单</title>
    <style type="text/css">
        li.menu{
            list-style-type: none; /*取消每个选项前的黑点*/
            float:right; /*让每一个li的内容从右向左浮动排列*/
            width: 120px; /*设置每个li的内容所占宽度为120px*/
            margin-right:30px; /*每个li间隔30px*/
            color:white;
        }
    </style>
</head>
<body>
    <div style="background-color: cornflowerblue;width: 100%;height: 90px">
        <ul style="position: absolute; right:5%; top:40px;">
            <li class="menu">退出登录</li>
            <li class="menu">修改登录密码</li>
            <li class="menu">我的信息</li>
            <li class="menu">我的订单</li>
        </ul>
    </div>

</body>
</html>
