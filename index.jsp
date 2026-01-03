<%--
  有风旅行的主页
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
    <link rel="stylesheet" href="../css/index.css">


</head>

<body>
<!-- 导航 -->
<iframe style="height:40px" align="center" width="100%" src="nav.jsp" frameborder="no" border="0" marginwidth="0"
        marginheight="0" scrolling="no"></iframe>


<!-- 横幅广告 -->
<section class="banner" id="banner">
    <ul id="carousel_list" class="carousel_list">
        <li>
            <img src="../images/banner1.jpg" alt="">
        </li>
    </ul>

</section>

<!-- 页面搜索框 -->
<div class="header-con">
    <div class="header-center">
        <form action="index.do" method="get">
        <h1>去有风的地方</h1>
            <div class="soso-box">
                <input type="text" name="city" placeholder="查询目的地">
                <a href="">&#xe62d;</a>
            </div>
            <div class="soso-box">
                <input type="text" name="detailaddr" placeholder="详细地址">
                <a href="">&#xe62d;</a>
            </div>
            <div class="soso-box">
                <input type="text" name="hotelname" placeholder="酒店名称">
                <button type="submit" class="btn iconfont">&#xe62d;</button>
            </div>
        </form>
    </div>
</div>


<!-- 页面主内容 -->
<div class="mainbox0">
    <img src="../images/hotel-tj.gif" width="600px" height="100px">

</div>

<div class="mainbox">
    <c:forEach items="${hotelList}" var="hotel">
        <div class="sbox">  <!--酒店内容开始-->
            <a href="hotelinfo.do?hotelid=${hotel.hotelid}">
                <div class="picbox">
                    <img src="/upload/${hotel.photourl}" alt="">
                </div>
                <div class="wordbox">
                    <h1>${hotel.hotelname}</h1>
                    <p class="wz06">${hotel.province}.${hotel.city}.${hotel.detailaddr}<br>
                        特色：${hotel.features}<br>
                        服务：${hotel.server}</p>
                    <p style="margin-top: 20px;">
                    <div>
                        <div class="left">
                            <span>￥</span><span class="wz04">${hotel.minprice}</span><span class="wz05">起</span>
                        </div>
                        <div class="right">
                            <span>122条点评</span><span>4.8分超棒</span>
                        </div>
                    </div>
                    </p>
                </div>
            </a>
        </div>  <!--酒店内容结束-->
    </c:forEach>
</div>

<!-- 页脚 -->

<iframe style="height:280px" align="center" width="100%" src="footer.jsp" frameborder="no" border="0"
        marginwidth="0" marginheight="0" scrolling="no"></iframe>

</body>

</html>

