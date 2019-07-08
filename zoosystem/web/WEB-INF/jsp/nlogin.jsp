<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/7/3
  Time: 14:57
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
    <form action="/login" method="post">
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
        <a href="/register">没有账号？立即注册</a>
    </div>
    <div class="logon-box">
        <a href="/home">不登了，我要去首页</a>
    </div>
</div>

</body>
</html>
<%--<!DOCTYPE HTML>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>夕阳红动物园</title>--%>
<%--    <link href="resources/css/strap.css" rel="stylesheet" type="text/css" media="all">--%>
<%--    <link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
<%--    <script type="application/x-javascript">--%>
<%--        addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);--%>
<%--        function hideURLbar(){ window.scrollTo(0,1); }--%>
<%--    </script>--%>
<%--    <script src="resources/js/jquery-1.11.1.min.js"></script>--%>
<%--    <script src="resources/js/strap.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<!--header-->--%>
<%--<!-- 自己修改的-->--%>
<%--<div class="header">--%>
<%--    <div class="container">--%>
<%--        <div class="header-top">--%>
<%--            <nav class="navbar navbar-default">--%>
<%--                <div class="container-fluid">--%>
<%--                    <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--                    <div class="navbar-header">--%>
<%--                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">--%>
<%--                            <span class="sr-only">Toggle navigation</span>--%>
<%--                            <span class="icon-bar"></span>--%>
<%--                            <span class="icon-bar"></span>--%>
<%--                            <span class="icon-bar"></span>--%>
<%--                        </button>--%>
<%--                        <div class="navbar-brand">--%>
<%--                            <h1><a href="index.html">夕阳红动物园</a></h1>--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <!-- Collect the nav links, forms, and other content for toggling -->--%>
<%--                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
<%--                        <ul class="nav navbar-nav">--%>
<%--                            <li class="active"><a href="index.html">首页 <span class="sr-only">(current)</span></a></li>--%>
<%--                            <li><a href="/intro">介绍</a></li>--%>
<%--                            <li><a href="/notice">公告</a></li>--%>
<%--                            <li class="dropdown">--%>
<%--                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">场馆 </a>--%>
<%--                            </li>--%>
<%--                            <li><a href="/star">明星动物</a></li>--%>
<%--                            <li><a href="/reserve">预定</a></li>--%>
<%--                        </ul>--%>

<%--                    </div><!-- /.navbar-collapse -->--%>
<%--                </div><!-- /.container-fluid -->--%>
<%--            </nav>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<!-- 这是主题图片-->--%>
<%--<div class="testimonials">--%>
<%--    <div class="container">--%>

<%--    </div>--%>
<%--</div>--%>
<%--<div>--%>

<%--    <form action="/login" method="post">--%>
<%--        <input type="text" name="username" placeholder="username"/><br/>--%>
<%--        <input type="password" name="password" placeholder="password"/><br/>--%>
<%--        <input type="submit" value="登录">--%>
<%--    </form>--%>
<%--    <form action="/register" method="get">--%>
<%--        <input type="submit" name="register" value="没有账号，点我注册">--%>
<%--    </form>--%>
<%--</div>--%>
<%--<!--footer-->--%>
<%--<div class="footer-section">--%>
<%--    <div class="container">--%>
<%--        <div class="footer-top">--%>
<%--            <p>Technical support provided by 夕阳红</p>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
