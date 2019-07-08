<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/7/2
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>夕阳红动物园</title>
    <link href="resources/css/strap.css" rel="stylesheet" type="text/css" media="all">
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript">
        addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <script src="resources/js/jquery-1.11.1.min.js"></script>
    <script src="resources/js/strap.js"></script>
</head>
<body>
<!--header-->
<!-- 自己修改的-->
<div class="header">
    <div class="container">
        <div class="header-top">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <div class="navbar-brand">
                            <h1><a href="index.html">夕阳红动物园</a></h1>
                        </div>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="/home">首页</a></li>
                            <li><a href="/intro">介绍</a></li>
                            <li><a href="/notice">公告</a></li>
                            <li class="dropdown">
                                <a href="/zone" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">场馆 </a>
                                <%--                                <ul class="dropdown-menu">--%>
                                <%--                                    <li><a href="/giraffe">giraffe</a></li>--%>
                                <%--                                    <li><a href="/elephant">elephant</a></li>--%>
                                <%--                                    <li><a href="/penguin">penguin</a></li>--%>
                                <%--                                    <li><a href="/koala">koala</a></li>--%>
                                <%--                                    <li><a href="/sea">sea</a></li>--%>
                                <%--                                    <li><a href="/bird">bird</a></li>--%>
                                <%--                                    <li><a href="/monkey">monkey</a></li>--%>
                                <%--                                </ul>--%>
                            </li>
                            <li><a href="/star">明星动物</a></li>
                            <li><a href="/reserve">预定</a></li>
                        </ul>

                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

        </div>
    </div>
</div>
<!-- 这是主题图片-->
<div class="testimonials">
    <div class="container">

    </div>
</div>
<!-- 公告-->
<div class="about-section">
    <div class="container">
        <div class="about-grids">
            <div class="col-md-4 about-grid">
                <img src="resources/img/np3.jpg" class="img-responsive" alt="/">
                <div class="about1">
                    <h4>公告和最新活动</h4>
                </div>
            </div>
            <div class="col-md-8 about-grid">
                <h3>公告</h3>
                <div class="history">
                    <h5>公告一</h5>
                    <p>&nbsp;为进一步做好保险服务工作，更好实现公平、公正原则，特新邀：中国人民财产保险股份有限公司成都市分公司参加夕阳红动物园公众责任险及交通工具意外险项目比选，原定于2019年6月25日比选延期至2019年6月27日。特此公告</p>
                    <p style="align:right">夕阳红动物园 19.7.1</p>
                </div>
                <div class="history1">
                    <h5>公告二</h5>
                    <p>&nbsp;为进一步做好保险服务工作，更好实现公平、公正原则，特新邀：中国人民财产保险股份有限公司成都市分公司参加成都动物园公众责任险及交通工具意外险项目比选，原定于2019年6月25日比选延期至2019年6月27日。特此公告！</p>
                    <p style="align:right">夕阳红动物园 19.7.2</p>
                </div>
                <div class="history2">
                    <h5>公告三</h5>
                    <p>&nbsp;夕阳红动物园诚邀：中华联合财产保险股份有限公司龙泉支公司，根据项目需要，按照符合需求，质量和服务相关等、且报价最低的原则，通过比选方式确定成都动物园公众责任险及职工交通意外险的服务单位。</p>
                    <p style="align:right">夕阳红动物园 19.7.2</p>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<!--footer-->
<div class="footer-section">
    <div class="container">
        <div class="footer-top">
            <p>Technical support provided by 夕阳红</p>
        </div>
    </div>
</div>
</body>
</html>
