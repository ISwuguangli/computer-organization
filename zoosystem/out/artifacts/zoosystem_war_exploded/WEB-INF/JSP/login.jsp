<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/6/25
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <form action="/login" method="post">--%>
<%--        <input name="username" type="text"/><br/>--%>
<%--        <input name="password" type="password"/><br/>--%>
<%--        <input type="submit" value="sign up"/>--%>
<%--    </form>--%>
<%--</body>--%>
<%--</html>--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="resources/img/apple-icon.png">
    <link rel="icon" type="image/png" href="resources/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>登录</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!--     Fonts and icons     -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">

    <!-- CSS Files -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
    <link href="resources/css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="resources/css/demo.css" rel="stylesheet" />
</head>

<body>
<div class="image-container set-full-height" style="background-image: url('resources/img/wizard.jpg')">

    <!--   Big container   -->
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">

                <!--      Wizard container        -->
                <div class="wizard-container">

                    <div class="card wizard-card" data-color="green" id="wizardProfile">
                        <form action="" method="">
                            <!--        You can switch ' data-color="orange" '  with one of the next bright colors: "blue", "green", "orange", "red"          -->

                            <div class="wizard-header">
                                <h3>
                                    <b>夕阳红动物园</b>
<%--                                    <b>BUILD</b> YOUR PROFILE <br>--%>
<%--                                    <small>This information will let us know more about you.</small>--%>
                                </h3>
                            </div>

                            <div class="wizard-navigation">
                                <ul>
                                    <li><a href="#about" data-toggle="tab">登录</a></li>
                                </ul>

                            </div>

                            <div class="tab-content">
                                <div class="tab-pane" id="about">
                                    <div class="row">
                                        <div class="col-sm-4 col-sm-offset-1">
                                            <div class="picture-container">
                                                <div class="picture">
                                                    <img src="resources/img/default-avatar.png" class="picture-src" id="wizardPicturePreview" title=""/>
                                                    <input type="file" id="wizard-picture">
                                                </div>
                                                <h6>Choose Picture</h6>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <form action="/rlogin" method="post">
                                                <div class="form-group">
                                                    <label>用户名</label>
                                                    <input name="username" type="text" class="form-control" placeholder="这里是在动物园的昵称嗷">
                                                </div>
                                                <div class="form-group">
                                                    <label>密码</label>
                                                    <input name="password" type="password" class="form-control" placeholder="不要超过32位嗷">
                                                </div>
<%--                                                <div class="pull-right"  style="color:#05AE0E ">--%>
<%--                                                    <input type='submit' class='btn btn-finish btn-fill btn-warning btn-wd btn-sm' name='finish' value='登录' />--%>
<%--                                                </div>--%>
                                                <input type="submit" value="登录">
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div> <!-- wizard container -->
            </div>
        </div><!-- end row -->
    </div> <!--  big container -->

    <div class="footer">
        <div class="container">

        </div>
    </div>

</div>

</body>

<!--   Core JS Files   -->
<script src="resources/js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="resources/js/gsdk-bootstrap-wizard.js"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="resources/js/jquery.validate.min.js"></script>

</html>
