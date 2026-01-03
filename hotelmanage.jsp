<%--
  管理员对酒店的管理页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="importhead.jsp"%>
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
    <link rel="stylesheet" href="../css/hotelmanage.css">

</head>

<body>


<!-- 导航 -->
<iframe style="height:40px" align="center" width="100%" src="nav.jsp" frameborder="no" border="0" marginwidth="0"
        marginheight="0" scrolling="no"></iframe>

<!-- 横幅广告 -->
<section class="banner" id="banner">
    <ul id="carousel_list" class="carousel_list">
        <li>
            <img src="../images/banner6.jpg" alt="">
        </li>
    </ul>

</section>

<div class="ju"></div>
<div class="gd"><img src="../images/518.jpg"></div>

<!-- 页面主内容 -->

<center>


    <div class="hymc">


        <div class="qymc">
            <h1>企业名称： ${hoteladmin.companyname}</h1>
        </div>
        <div>

            <div class="l">
                <p>管理员账号：  ${hoteladmin.userid}</p>
                <p>管理员联系电话：  ${hoteladmin.mobile}</p>
            </div>
            <div class="r">
                <p>管理员姓名：  ${hoteladmin.username}</p>
                <p>管理员邮箱：  ${hoteladmin.mail}</p>
            </div>

        </div>
        <div class="clearfix"></div>
        <div class="ju"></div>
        <div class="l">
            <a class="button" href="edithotel.do">添加酒店</a>
        </div>


    </div>
    <div class="clearfix"></div>
    <div class="ju"></div>

    <div class="jdgl">

        <img src="../images/hotel-gl.gif">
    </div>

    <div class="box">
        <div class="box01">
            <ul>
                <li>酒店名称</li>
                <li>酒店地址</li>
                <li>酒店电话</li>
                <li>操作</li>
            </ul>

        </div>
    </div>
    <c:forEach items="${hotelList}" var="hotel">
        <div class="inner">
            <div class="box3"><img src="/upload/${hotel.photourl}"></div>
            <div class="box4">
                <ul>
                    <li>
                        <h3>${hotel.hotelname}</h3>
                    </li>
                    <li>
                        <p class="w1">${hotel.province}.${hotel.city}.${hotel.detailaddr}</p>
                    </li>
                    <li>
                        <p class="w2">${hotel.tels}</p>
                    </li>
                    <li>
                        <p class="w3"><a href="../hotelbookinginfo.html" class="button">查看订单</a>
                            <a href="hotelinfo.do?hotelid=${hotel.hotelid}" class="button">管理酒店</a>
                        </p>
                    </li>
                </ul>
            </div>
        </div>

        <div class="clearfix"></div>
        <div class="box02">
            <hr>
        </div>
    </c:forEach>
</center>

<!-- 页脚 -->

<iframe style="height:280px" align="center" width="100%" src="footer.jsp" frameborder="no" border="0"
        marginwidth="0" marginheight="0" scrolling="no"></iframe>

</body>

</html>