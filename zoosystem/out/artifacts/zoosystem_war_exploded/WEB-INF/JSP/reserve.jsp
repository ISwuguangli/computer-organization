<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/7/2
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>预定票</title>
    <link rel="stylesheet" type="text/css" href="resources/css/reserve.css">
</head>
<body>
<div id="content">
    <div class="login-header">
        预定
    </div>

<p>${nmatch}</p>
<form action="/doreserve" method="post" align="center">
    <input type="text"  name="iphone" placeholder="手机号"/><br/>
    <li>时间段</li><input type="radio" name="time" value=0 onclick="changePrice()" checked />周一~周五
    <input type="radio" name="time" onclick="changePrice()" value=1 />周六
    <input type="radio" name="time" onclick="changePrice()" value=2 />周日<br/>
    <input type="text" name="price" id="price" value=" "/>
    <input type="submit" value="预定" >
    <div class="logon-box">
        <a href="/home">不买了，我要去首页</a>
    </div>
</form>

</div>
<%
    //判断session
    if (session.getAttribute("username")==null) response.sendRedirect("nlogin");
%>
<script>
    function changePrice(){
        var radios = document.getElementsByName("time");
        var value = 0;
        for(var i=0;i<radios.length;i++){
            if(radios[i].checked == true){
                value = radios[i].value;
            }
        }
        var price = value*10+30;
        document.getElementById("price").value=price;
        // alert(value);
    }
    function showWin() {
        alert("预定成功");
    }
</script>
</body>
</html>
