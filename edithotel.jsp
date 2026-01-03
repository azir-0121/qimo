<%--
  酒店信息编辑页面
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
    <link rel="stylesheet" href="../css/edithotel.css">
    <script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
    <script>
        $(function(){
            $("#choicePhoto").click(function (){
                    $("#fileToUpload").click()  //触发文件选择器的click()方法
                }
            )
            //当文件选择器选中一个文件，并打开后，就触发了change()方法
            $("#fileToUpload").change(function(){
                var files = $("#fileToUpload")[0].files;  //从文件选择器中获得选中的第一个文件
                if(files.length <=0){  //对选取的文件进行校验
                    return alert("请选择文件再上传");//不允许打开一个空文件(0K文件）
                }
                alert("上传文件名为：" + files[0].name);

                //创建一个表单form对象，用于包含文件，通过请求servlet发送文件
                var formData =new FormData(); //创建表单对象
                formData.append("file",files[0]); //将文件名加入到表单中

                $.ajax({  //使用ajax异步调用服务器中的url
                    url:"upload.do",
                    data:formData,
                    cache:false,
                    type:"post",
                    datatype:"json",
                    contentType:false, //不设置内容类型
                    processData:false, //不处理数据
                    success:function (data){
                        if(data.code==0) {  //当data.code==0的时候代表上传文件成功
                            alert(data.msg); //显示从服务器中发回来的消息提示
                            $("#photourl").val(data.result); //把上传后存储在服务器中的文件名称回填给文本框
                            $("#hotelphoto").attr("src","/upload/"+data.result); //让酒店图片显示在网页中
                        }else{  //失败
                            alert(data.msg);
                        }
                    }
                })

            })

        })
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
            <img src="../images/banner6.jpg" alt="">
        </li>
    </ul>

</section>

<div class="jdgl">

    <!-- <img src="images/hotel-gl.gif"><br> -->

    <h1>酒店编辑</h1>
</div>

<div class="ju"></div>


<!-- 页面主内容 -->

<center>

    <form action="savehotel.do" method="post">
        <div class="edit">
            <div class="edit-left">
                <c:choose>
                    <c:when test="${hotel!=null && hotel.photourl!=null && hotel.photourl!=''}">
                        <img id="hotelphoto" src="/upload/${hotel.photourl}">
                    </c:when>
                    <c:otherwise>
                        <img id="hotelphoto" src="../images/无酒店背景.png">
                    </c:otherwise>
                </c:choose>
                <div>
                    <input type="text" id="photourl" name="photourl" value="${hotel.photourl}" readonly>
                    <input class="button" type="button" value="选择图片" id="choicePhoto">
                    <!-- 隐藏file标签 -->
                    <input id="fileToUpload" style="display:none" type="file" name="upfile" />
                </div>

            </div>
            <div class="edit-right">
                <table>
                    <tr>
                        <td>酒店编号</td>
                        <td><input type="text" name="hotelid" value="${hotel.hotelid}" readonly></td>
                    </tr>
                    <tr>
                        <td>酒店名称</td>
                        <td><input type="text" name="hotelname" value="${hotel.hotelname}"></td>
                    </tr>
                    <tr>
                        <td>所在国家</td>
                        <td><input type="text" name="country" value="${hotel.country}"></td>
                    </tr>
                    <tr>
                        <td>所在省份</td>
                        <td><input type="text" name="province" value="${hotel.province}"></td>
                    </tr>
                    <tr>
                        <td>所辖城市</td>
                        <td><input type="text" name="city" value="${hotel.city}"></td>
                    </tr>
                    <tr>
                        <td>所在城市详细地址</td>
                        <td>
                            <input type="text" name="detailaddr" value="${hotel.detailaddr}">
                        </td>
                    </tr>
                    <tr>
                        <td>酒店服务电话</td>
                        <td><input type="text" name="tels" value="${hotel.tels}"></td>
                    </tr>
                    <tr>
                        <td>酒店特色介绍</td>
                        <td><textarea rows="3" class="textarea" name="features">${hotel.features}</textarea></td>
                    </tr>
                    <tr>
                        <td>酒店相关服务</td>
                        <td><textarea rows="3" class="textarea" name="server">${hotel.server}</textarea></td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input class="button" type="submit" value="提交保存">
                            <input class="button" type="reset" value="取消返回">
                        </td>
                    </tr>
                </table>
            </div>

        </div>
    </form>
</center>

<!-- 页脚 -->

<iframe style="height:280px" align="center" width="100%" src="footer.jsp" frameborder="no" border="0"
        marginwidth="0" marginheight="0" scrolling="no"></iframe>

</body>

</html>