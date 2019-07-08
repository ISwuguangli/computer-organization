<%--
  Created by IntelliJ IDEA.
  User: wuguangli
  Date: 2019/6/28
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testpost</title>
</head>
<body>
<form action="/testPost" method="post">
    <div class="form-group">
        <label>用户名</label>
        <input name="username" type="text" class="form-control" placeholder="这里是在动物园的昵称嗷">
    </div>
    <div class="form-group">
        <label>密码</label>
        <input name="password" type="password" class="form-control" placeholder="不要超过32位嗷">
    </div>
    <div class="pull-right"  style="color:#05AE0E ">
        <input type="submit" class='btn btn-finish btn-fill btn-warning btn-wd btn-sm'  value='登录' />
    </div>
</form>
</body>
</html>
