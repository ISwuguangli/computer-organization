<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/7/2
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/6/25
  Time: 16:32
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
<!-- 导航栏-->
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
                            <li class="active"><a href="/home">首页 </a></li>
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
<!-- 主题图片-->
<div class="banner-header">
    <div class="container">
        <h2>明星动物</h2>
    </div>
</div>
<!-- 公告模块-->
<!-- 动物跑马灯-->

<!-- 主题场馆-->

<!-- 主题场馆2-->
<div class="content">
    <!--services-->
    <div class="services-section">
        <div class="container">
            <div class="services-grids">
                <div class="col-md-3 services-grid">
                    <img src="resources/img/s1.jpg" class="img-responsive" alt="" />
                    <div class="services-info">
                        <h4>鹦鹉啾啾</h4>
                        <p>古人名物就为物赋予文化意蕴,鹦鹉亦是如此,或寓意祥瑞与智慧,或譬喻仁义与孝道,抑或阐明道理等.</p>
                    </div>
                </div>
                <div class="col-md-3 services-grid">
                    <img src="resources/img/s2.jpg" class="img-responsive" alt="" />
                    <div class="services-info">
                        <h4>狒狒亚历山大</h4>
                        <p>主要地面活动，也爬到树上睡觉或觅食。善游泳。能发出很大叫声。白天活动，夜间栖于大树枝或岩洞中。</p>
                        <p>${name}&nbsp;${say}&nbsp;${commentMsg}</p>
                        <form action="/comment" method="post">
                            <input type="text"placeholder="请输入评论" name="cmsg"><br/>
                            <input type="submit"value="评论">
                        </form>
                    </div>
                </div>
                <div class="col-md-3 services-grid">
                    <img src="resources/img/s3.jpg" class="img-responsive" alt="" />
                    <div class="services-info">
                        <h4>麋鹿乔巴</h4>
                        <p>乔巴立志成为动物园里最萌的小鹿。被人夸奖会非常高兴。不知所措时，会流泪。在朋友遇到危难时，会变得特别勇敢。</p>
                    </div>
                </div>
                <div class="col-md-3 services-grid">
                    <img src="resources/img/s4.jpg" class="img-responsive" alt="" />
                    <div class="services-info">
                        <h4>豹子王辛巴</h4>
                        <p>辛巴是一个喜欢历险的叛逆的可爱小豹子，过着无忧无虑的生活，他认为他应该得到一切他想要的，因为它就是未来的豹子王。</p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
<%--    <div align="center"><input type="button"value="评论"></div>--%>

    <!--services-->
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

