<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/7/4
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>
<body>

<div id="content">
    <div class="login-header">
        登录
    </div>
    <form action="/clogin" method="post">
        <div class="login-input-box">
            <span class="icon icon-user"></span>
            <input type="text" placeholder="用户名" name="username">
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" placeholder="密码" name="password">
        </div>
        <div class="remember-box">
            <label>
                <input type="checkbox">记住密码
            </label>
        </div>
        <div class="login-button-box" align="center">
            <input type="submit" value="登录">
        </div>
    </form>
    <div class="logon-box">
        <a href="/cregister">没有账号？立即注册</a>
    </div>
</div>

</body>
</html>
