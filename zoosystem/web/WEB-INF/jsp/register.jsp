<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/6/25
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>
<body>

<div id="content">
    <div class="login-header">
        注册
    </div>
    <p name="rmsg">${Rmsg}</p>
    <form action="/register" method="post">
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input type="text" placeholder="用户名" name="username">
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" placeholder="密码" name="rpassword">
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" placeholder="密码" name="cpassword">
        </div>
        <div class="login-button-box" align="center">
            <input type="submit" value="注册">
        </div>
        <div class="logon-box">
            <a href="/home">不登了，我要去首页</a>
        </div>
    </form>

</div>
<script>
    // function (){
    //     var radios = document.getElementsByName("time");
    //     var value = 0;
    //     for(var i=0;i<radios.length;i++){
    //         if(radios[i].checked == true){
    //             value = radios[i].value;
    //         }
    //     }
    //     var price = value*10+30;
    //     document.getElementById("price").value=price;
    //     // alert(value);
    // }
    // function showWin() {
    //     alert("预定成功");
    // }
    // var amount = getRadioButtonChecked("dateTime");
    // console.log("amount=="+amount);
    //
    // /**
    //  * 获取input = radio 单选框中选中的值
    //  * @param tagNameAttr string  radio组中input的name属性值
    //  * return 返回被选中radio的值
    //  */
    // function getRadioButtonCheckedValue(tagNameAttr){
    //     var radio_tag = document.getElementsByName(tagNameAttr);
    //     for(var i=0;i<radio_tag.length;i++){
    //         if(radio_tag[i].checked){
    //             var checkvalue = radio_tag[i].value;
    //             return checkvalue;
    //         }
    //     }
    // }
    // function changePrice() {
    //     var temp = getRadioButtonCheckedValue(dateTime);
    //     document.getElementById("price").value=temp;
    // }
</script>
</body>
</html>
<%--<html>--%>
<%--<head>--%>
<%--    <title>sign up</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<!-- 加入js判断功能-->--%>
<%--    <form action="/register" method="post">--%>
<%--        <input type="text" name="rname"/><br/>--%>
<%--        <input type="password" name="rpassword"/><br/>--%>
<%--        <input type="password" name="cpassword"/><br/>--%>
<%--        <input type="submit" value="sign up">--%>
<%--    </form>--%>
<%--</body>--%>
<%--</html>--%>
