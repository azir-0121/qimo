<%--
  酒店管理员注册页面
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
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/css.css">
    <link rel="stylesheet" href="../css/addhotelmember.css">
</head>
<body>
<section>
    <div class="login">
        <div>
            <form action="addhotelmember.do" method="post">
                <table style="width: 100%;">
                    <tr>
                        <td colspan="4"
                            style="font-size:22px;font-weight: 700; border-bottom: #f9f4f4 1px solid; text-align: center;">
                            酒店会员注册
                        </td>
                    </tr>
                    <tr>
                        <td>会员账号</td>
                        <td><input type="text" class="inputstyle" name="userid"></td>
                        <td>会员姓名</td>
                        <td><input type="text" class="inputstyle" name="username"></td>
                    </tr>
                    <tr>
                        <td>登录密码</td>
                        <td><input type="password" class="inputstyle" name="pwd"></td>
                        <td>联系手机号码</td>
                        <td><input type="text" class="inputstyle" name="mobile"></td>
                    </tr>
                    <tr>
                        <td>再次输入密码</td>
                        <td><input type="password" class="inputstyle" name="pwd2"></td>
                        <td>联系邮箱</td>
                        <td><input type="text" class="inputstyle" name="mail"></td>
                    </tr>
                    <tr>
                        <td>企业名称</td>
                        <td><input type="text" class="inputstyle" name="companyname"></td>
                        <td></td>
                        <td rowspan="2">
                            <img id="licencephotocontent" height="80" style="border: #A9A9A9 1px solid"
                                 src="../images/hotellicence_meitu_1.jpg">
                        </td>
                    </tr>
                    <tr>
                        <td>上传企业营业执照</td>
                        <td><input type="text" class="inputstyle" name="licencephoto" disabled="true"></td>
                        <td><input type="button" class="uploaduttoncss" name="uploadphoto" value="上传文件"></td>
                    </tr>
                    <tr>
                        <td colspan="4" style="text-align: center;">
                            <input type="submit" class="orangebuttoncss" name="login" value="注册">
                            <input type="button" class="bluebuttoncss" name="reset" value="取消">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</section>
</body>
</html>