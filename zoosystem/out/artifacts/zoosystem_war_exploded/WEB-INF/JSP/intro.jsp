<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/7/2
  Time: 17:06
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
<div class="banner-header">
    <div class="container">
        <h2>关于我们</h2>
    </div>
</div>
<!--about-->
<div class="content">
    <div class="about-section">
        <div class="container">
            <div class="about-grids">
                <div class="col-md-4 about-grid">
                    <h3>关于我们</h3>
                    <img src="resources/img/p2.jpg" class="img-responsive" alt="/">
                    <div class="about1">
                        <h4>这是一家怎样的动物园</h4>
                        <p>夕阳红动物园是中国开放最早，珍禽异兽种类最多的动物园，距今已有九十余年的历史。它位于西城区西直门外，占地面积约九十公顷，饲养展览动物九百余种两万多只，每年接待中外游客 600 多万人次。它有理想、有节操，绝对让你流连往返</p>
                    </div>
                    <div class="about2">
                        <h4>主要园区</h4>
                        <p>我们有长颈鹿、大象、小企讷、考拉、海洋小动物、百鸟苑、小猴几</p>
                    </div>
                    <div class="about2">
                        <h4>开放时间:周一~周日 08:30~18:30</h4>
                    </div>
                </div>
                <div class="col-md-4 about-grid">
                    <h3>我们的历史吖</h3>
                    <div class="history">
                        <h5>1997-2001</h5>
                        <p> 夕阳红动物园始建于1997年，是经中国动物园想象组织协会编委批准的差额预算事业单位，是成都市唯一一座综合性城市动物园。</p>

                    </div>
                    <div class="history1">
                        <h5>2003-2005</h5>
                        <p>2003年从百花潭迁于现址，经过50多年的建设与发展，已成为常年展出各种兽类、两栖爬行类、鸟类以及观赏鱼类等国家保护的珍稀濒危野生动物300余种、3000余只（头）的专类公园。</p>

                    </div>
                    <div class="history2">
                        <h5>2007-2009</h5>
                        <p>2007年12月，北京动物园已经建立“精子银行”，今后凡遇珍稀动物死亡，兽医都会第一时间通知“精子库”来取精，然后放入液氮罐中保存。</p>
                    </div>
                    <div class="history3">
                        <h5>2009-2014</h5>
                        <p>2009年9月，对旧猴山进行改建。因地势、周边环境等因素，已根本不可能再恢复原貌，原山体被玻璃幕墙环绕，面积也有所减少。10月完工开放。</p>
                    </div>
                </div>
                <div class="col-md-4 about-grid">
                    <h3>一起来玩耍啊</h3>
                    <div class="trend">
                        <p>在玩耍前，你要知道这些</p>
                    </div>
                    <div class="about1">
                        <h4>参观须知</h4>
                        <p>1、1.2米以下儿童需大人陪伴</p>
                        <p>2、禁止投喂</p>
                    </div>
                    <div class="about2">
                        <h4>参观导览</h4>
                        <p>我们有长颈鹿、大象、小企讷、考拉、海洋小动物、百鸟苑、小猴几</p>
                    </div>
                    <div class="trend">
                        <h4>我们的地图</h4>
                        <img src="resources/img/nMap.png" class="img-responsive" alt="/">
                        <ul>
                            <li><a href="/map">点击这里查看大图</a></li>
                        </ul>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!--about-->
    <div class="ourteam">
        <div class="container">
            <h3>我们的团队</h3>
            <div class="team-grids">
                <div class="col-md-3 team-grid"></div>
                <div class="col-md-3 team-grid">
                    <img src="resources/img/h.jpg" class="img-responsive" alt="" />
                    <h4>韩可心</h4>
                    <p>数据库、美工、service、dao、entity层编写者</p>
                </div>
                <div class="col-md-3 team-grid">
                    <img src="resources/img/w.jpg" class="img-responsive" alt="" />
                    <h4>吴广丽</h4>
                    <p>controller层、前端</p>
                </div>
                <div class="col-md-3 team-grid"></div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="ourteam">
        <div class="container">
            <div class="team-grids">
                <div class="col-md-4 team-grid">
                    <img src="resources/img/c.jpg" class="img-responsive" alt="" />
                    <h4>陈美凤</h4>
                    <p>注册页面</p>
                </div>
                <div class="col-md-4 team-grid">
                    <img src="resources/img/z.jpg" class="img-responsive" alt="" />
                    <h4>朱衍静</h4>
                    <p>预定页面</p>
                </div>
                <div class="col-md-4 team-grid">
                    <img src="resources/img/wan.jpg" class="img-responsive" alt="" />
                    <h4>王晓茜</h4>
                    <p>登录页面</p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>


    <!--advantage-->

    <!--advantage-->
    <!--specials-->

</div>
<!--footer-->
<div class="footer-section">
    <div class="container">
        <div class="footer-top">
            <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
        </div>
    </div>
</div>
</body>
</html>
