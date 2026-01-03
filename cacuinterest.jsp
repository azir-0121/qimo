<%--
  通过本页面用户录入本金，利率和年限，提交系统进行计算
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>银行利息计算</title>
</head>
<body>
    <center>
        银行利息计算
        <form action="cacu.do" method="post">
            您的存款金额：<input type="number" name="money"/> <br>
            您选择的存款年限: <input type="number" name="year" /> <br>
            该年限下的存款利率：<input type="text" name="rate" /> <br>
            <input type="submit" value="开始计算"/>
        </form>
    </center>
</body>
</html>
