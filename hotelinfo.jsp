<%@include file="importhead.jsp"%>
<%--
  酒店客房信息页面
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
    <link rel="stylesheet" href="../css/hotelinfo.css">
    <script type="text/javascript">
        function delhotel(hotelid){
            var a = confirm("您确定要删除当前酒店及其房间信息吗？")
            if(a==true){
                //如果选择了确定，则调用serlvet实现酒店的删除
                document.location.href="deletehotel.do?hotelid="+hotelid;
            }
        }
    </script>
</head>

<body>
<!-- 导航 -->
<iframe style="height:40px" align="center" width="100%" src="nav.jsp" frameborder="no" border="0" marginwidth="0"
        marginheight="0" scrolling="no"></iframe>
<!-- 横幅广告 -->
<section class="banner" id="banner">
    <ul id="carousel_list" class="carousel_list">
        <li>
            <img src="../images/banner9.jpg" alt="">
        </li>
    </ul>

</section>

<!-- 页面主内容 -->

<center>


    <!--酒店信息-->
    <div style="clear:both"></div>
    <div style="width:1160px;height:40px; margin-top:10px;">
        <a class="button4" style="display: block;" href="javascript:delhotel(${hotel.hotelid})">删除酒店信息</a>
        &nbsp;&nbsp;
        <a class="button2" style="display: block;" href="edithotel.do?hotelid=${hotel.hotelid}">编辑酒店信息</a>
        <a class="button3" style="width:130px; display: block;" href="../hotelbookinginfo.html">查看酒店订单信息</a>

    </div>
    <div class="clearfix"></div>
    <div class="hotel-tj-title">
        <img src="../images/hotel-hot.gif">
    </div>

    <div class="hotel-tj">
        <div class="hotel-tj-left"><img src="/upload/${hotel.photourl}"></div>
        <div class="hotel-tj-right">

            <h1>${hotel.hotelname}</h1>
            <p>${hotel.province}.${hotel.city}.${hotel.detailaddr}</p>
            <p>特色：${hotel.features}</p>
            <p>服务：${hotel.server}</p>
            <p style="margin-top:10px">酒店电话：${hotel.tels}</p>
        </div>
    </div>

    <div class="clearfix"></div>

    <div class="hotel-bz">
        <img src="../images/Snipaste_2024-05-18_15-34-14.jpg" alt="">
    </div>

    <div class="fyxx-title">
        <img src="../images/hotel-rz.gif">
    </div>
    <div class="fyxx">
        <div class="nav">
            <ul>
                <li>房型</li>
                <li>面积</li>
                <li>床型</li>
                <li>服务</li>
                <li>wifi</li>
                <li>可入住人数</li>
                <li>价格</li>
                <li><a href="" class="button">添加房型</a></li>
            </ul>
        </div>

        <div class="fyjg">

            <div class="inner">
            <c:forEach items="${roomList}" var="room">
                <div class="box1"> <!--房间内容开始-->
                    <img src="/upload/${room.photourl}">
                </div>
                <div class="box2">
                    <ul>
                        <li>
                            <p class="title">${room.roomtype}</p>
                        </li>
                        <li>
                            <p class="w1">${room.area}平方米</p>
                        </li>
                        <li>
                            <p class="w1">${room.bedtype}</p>
                        </li>
                        <li>
                            <p class="w1">${room.roomserver}</p>
                        </li>
                        <li>
                            <p class="w1">${room.wifi}</p>
                        </li>
                        <li>
                            <p class="w1">${room.personamount}人</p>
                        </li>
                        <li>
                            <p class="w1"><strong>￥${room.price}</strong></p>
                        </li>
                        <li>
                            <p class="w1"><a class="hotel_yt" href="../editbooking.html">订房</a></p>
                        </li>
                        <li>
                            <p class="w1"><a class="s5" href="#">编辑</a> | <a class="s5" href="#">删除</a></p>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"></div>
                <hr>
                <!--房间内容结束-->
            </c:forEach>
            </div>
        </div>
    </div>

    <div class="pl">
        真实用户评论
        <hr>
        <div class="top">
            <ul>
                <li>全部评论200条</li>
            </ul>
            <a href="#">更多>></a>
            <div>
                <div class="both"></div>
                <div class="main">
                    <div class="userplist">

                        <div class="userface">
                            <div><img src="../images/u.jpeg"></div>
                            <div> M42****9949<br>
                                黄金贵宾</div>
                        </div>
                        <div class="userpl">
                            <span class="l">4.8/5 好评</span><span class="r">2024-12-31发表于昆明</span>
                            <div class="both"></div>
                            <p>酒店位置非常优越
                                之前看评论里没有说清楚 是在BTS的N4站Sanam Pao 3号出口 下楼梯左手边就有7-11 很方便
                                一直走到小路口左转就到酒店了
                                服务人员都很nice 热情、礼貌 会主动打招呼 积极解决问题
                                房间干净整洁 唯一不足就是太小了 双床房两个床是挨在一起的 没有其他多余空间 行李箱打开就基本没位置了
                                其他方面都很好 值得推荐</p>
                        </div>
                    </div>
                </div>

                <div class="main">
                    <div class="userplist">

                        <div class="userface">
                            <div><img src="../images/u.jpeg"></div>
                            <div> M42****9949<br>
                                白银贵宾</div>
                        </div>
                        <div class="userpl">
                            <span class="l">4.8/5 好评</span><span class="r">2024-12-28发表于昆明</span>
                            <div class="both"></div>
                            <p>酒店位置非常优越
                                之前看评论里没有说清楚 是在地铁 3号出口 下楼梯左手边就有7-11 很方便
                                一直走到小路口左转就到酒店了
                                服务人员都很nice 热情、礼貌 会主动打招呼 积极解决问题
                                房间干净整洁 唯一不足就是太小了 双床房两个床是挨在一起的 没有其他多余空间 行李箱打开就基本没位置了
                                其他方面都很好 值得推荐</p>
                        </div>
                    </div>
                </div>



            </div>

        </div>
    </div>
</center>
<!-- 页脚 -->

<iframe style="height:280px" align="center" width="100%" src="footer.jsp" frameborder="no" border="0"
        marginwidth="0" marginheight="0" scrolling="no"></iframe>

</body>

</html>
