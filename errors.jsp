<%--
  错误信息显示页面
--%>
<%@ include file="importhead.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>有风旅游</title>
    <meta name="Keywords" content="机票，酒店，旅游攻略，签证，出国，自由行">
    <meta name="Description" content="有风旅游有10多年旅游行业经验，为您提供全方位旅游服务">
    <link rel="stylesheet" href="../css/errors.css">
</head>
<body>
<!-- 页面主内容 -->
<div class="title">
    <h1>出错啦！</h1>
</div>
<div class="inner">
    <div class="edit">
        <div class="edit-left">
            <img src="../images/error.jpg">
        </div>
        <div class="edit-right">
            <div>
                <h2>${errMsg}</h2>  <%--错误信息需存储在内置对象中--%>
            </div>
            <a href="${backUrl}">返回上一个页面</a>
        </div>
    </div>
</div>
</body>
</html>

