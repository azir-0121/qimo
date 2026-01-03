<%@ include file="importhead.jsp"%>
<%--
  有风旅行的导航菜单页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>有风旅游</title>
    <meta name="Keywords" content="机票，酒店，旅游攻略，签证，出国，自由行">
    <meta name="Description" content="有风旅游有10多年旅游行业经验，为您提供全方位旅游服务">
    <link rel="stylesheet" href="../css/reset.css">
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/css.css">


</head>

<body>

<header class="site-head">

    <nav class="main-nav">
        <div class="center-wrap">
            <ul>
                <li>
                    <a href="index.do" target="_top">首页 |</a>
                </li>
                <%--酒店管理员登录--%>
                 <c:if test="${loginuser!=null && loginuser.utid==UserTypeProperties.HOTELADMINTYPE}">
                    <li>
                        <a href="hotelmanage.do" target="_top">我的酒店</a>
                    </li>
                    <li>
                        <a href="">酒店订单</a>
                    </li>
                    <li>
                        <a href="">我的信息</a>
                    </li>
                    <li>
                        <a href="logout.do" style="margin: 0px 15px;color:#e4ef4c">| 退出登录</a>
                    </li>
                <li><img style="vertical-align: middle;" src="../images/酒店.png">
                    您好，${loginuser.username}（${loginuser.utname}）
                </li>
                </c:if>
            <%--网站会员登录--%>
                <c:if test="${loginuser!=null && loginuser.utid==UserTypeProperties.MEMBERTYPE}">
                    <li>
                        <a href="">我的订单</a>
                    </li>
                    <li>
                        <a href="">我的信息</a>
                    </li>
                    <li>
                        <a href="logout.do" style="margin: 0px 15px;color:#e4ef4c">| 退出登录</a>
                    </li>
                <li>
                    <img style="vertical-align: middle;" src="../images/人员.png">
                    您好，${loginuser.username}（${loginuser.utname}）
                </li>
                </c:if>
                <%--用户未登录--%>
                <c:if test="${loginuser==null && loginuser.userid==null}">
                    <li>
                        <a href="">普通会员注册</a>
                    </li>
                    <li>
                        <a href="addhotelmember.jsp" target="_top">酒店会员注册</a>
                    </li>
                    <li>
                        <a href="login.jsp" target="_top" style="margin: 0px 15px;color:#e4ef4c">| 登录</a>
                    </li>
                    <li>
                        <img style="vertical-align: middle;" src="../images/人员.png">
                         用户，您还没有登录
                    </li>
                </c:if>

                <li>|</li>
                <li><img style="vertical-align: middle;" src="../images/人群.png"><span>当前访问人数：20人</span>


                </li>

            </ul>
        </div>

    </nav>

</header>

</body>

</html>