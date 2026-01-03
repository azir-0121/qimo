<%@ page import="service.UserService" %>
<%@ page import="service.UserServiceImpl" %>
<%@ page import="model.VUser" %>
<%@ page import="utils.UserTypeProperties"%>
<%@ page import="service.HotelService" %>
<%@ page import="service.HotelServiceImpl" %>
<%@ page import="model.THotel" %>
<%@ page import="java.util.List" %>
<%--
  学习jstl标签的使用方法
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("professional","软件工程专业");
    UserService userv = new UserServiceImpl();
    VUser loginuser = userv.login("admin1","1234567");
    session.setAttribute("loginuser",loginuser);

    HotelService hserv = new HotelServiceImpl();
    List<THotel> hotelList = hserv.getHotelsByNameAndCity("大理",null);
    request.setAttribute("hotelList",hotelList);
    //out.print(hotelList.size());
%>
<html>
<head>
    <title>学习JSTL标签</title>
</head>
<body>
    ---------学习c:out标签输出变量和常量的值------------------<br>
    输出常量的值：<c:out value="你好，JSTL标签 " ></c:out> <br>
    输出来自内置对象中的变量：<c:out value="${professional}"></c:out> <br>
    ---------学习c:set标签设置值到内置对象中------------------<br>
    <c:set var="clsname" value="2023级【本科】软件工程1班" scope="request"></c:set>
    <c:out value="${clsname}"></c:out> <br>
    ---------学习c:if标签根据条件实现if(){} 单分支控制流程-----<br>
    <c:if test="${loginuser!=null && loginuser.utid==UserTypeProperties.HOTELADMINTYPE}">
        你好，管理员，${loginuser.username}
    </c:if>
    <c:if test="${loginuser!=null && loginuser.utid==UserTypeProperties.MEMBERTYPE}">
        你好，会员，${loginuser.username}
    </c:if>
    <c:if test="${loginuser==null || loginuser.userid==null}">
        你好，用户，你还没有登录！
    </c:if>
    <br>
    ---------学习使用c:choose,c:when,c:otherwise实现if多分支条件语句------<br>
    <c:choose>
        <c:when test="${loginuser!=null && loginuser.utid==UserTypeProperties.HOTELADMINTYPE}}">
            我的酒店  酒店订单  我的信息  退出登录  <br>
        </c:when>
        <c:when test="${loginuser!=null && loginuser.utid==UserTypeProperties.MEMBERTYPE}}">
            我的订单  我的信息  退出登录  <br>
        </c:when>
        <c:otherwise>   <%--类似 else--%>
            酒店管理员注册   网站会员注册   登录 <br>
        </c:otherwise>
    </c:choose>
    -------学习使用c:forEach实现对集合中的元素进行迭代循环的操作-----------<br>
    <%--代替实现 for(THotel hotel: hotelList){}--%>
    <c:forEach items="${hotelList}" var="hotel">
        <img src="/upload/${hotel.photourl}" style="width: 180px; height: 120px"/>
        ${hotel.hotelname} &nbsp;&nbsp;
        ${hotel.province}.${hotel.city}.${hotel.detailaddr}
        <br><hr>
    </c:forEach>
    ------学习实用c:forEach实现固定次数的循环操作----------------------<br>
    <%--for(int i=1;i<=10;i++) {} --%>
    <c:forEach begin="1" end="10" step="1" var="i">
        ${i}&nbsp;
    </c:forEach>
    <br>
    ------使用c:forEach实现循环嵌套的九九乘法表----------------------<br>
    <c:forEach begin="1" end="9" step="1" var="i">
        <c:forEach begin="1" end="${i}" step="1" var="j">
            ${i}*${j}=${i*j}
        </c:forEach>
        <br>
    </c:forEach>
</body>
</html>
