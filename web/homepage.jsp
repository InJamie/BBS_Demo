<%--
  Created by IntelliJ IDEA.
  User: InJamie
  Date: 2020/5/25
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BBD论坛</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.js"></script>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.2.1.min.js"></script>

    <style>
        html {
            padding: 20px;
        }

        .body-main {
            padding: 20px;
            box-shadow: 7px 7px 20px rgba(0, 0, 0, 0.3);
            height: 682px;
        }

        #form {
            width: 580px;
            height: 200px;
            margin: 100px auto;
        }

        /*#img {*/
        /*    color: red;*/
        /*    font-size: 20px;*/
        /*    margin: 26px 123px 0px;*/
        /*}*/
        .register {
            margin-left: 80px;
            margin-right: 142px;
        }
    </style>
</head>
<body class="body-main">
<h1 style="text-align: center; margin: 50px;font-size: 68px">
    BBS
</h1>
<form class="form-horizontal" id="form" method="post" action="${pageContext.request.contextPath}/loginServlet">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" placeholder="请输入账号" name="user">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码" name="password">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
        <div class="col-sm-10">
            <input type="text" autocomplete=off class="form-control" id="CheckCode" placeholder="请输入验证码"
                   name="checkcode">

        </div>
        <img style="margin: 10px 120px" src="${pageContext.request.contextPath}/checkCodeServlet"
             onclick="changeCheckCode(this)" alt="">
        <script type="text/javascript">
            //图片点击事件
            function changeCheckCode(img) {
                img.src = "checkCodeServlet?" + new Date().getTime();
            }
        </script>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a href="${pageContext.request.contextPath}/register.jsp" type="button"
               class="btn btn-default register">注册</a>
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
    <strong style="color: red">${img}</strong>
</form>
</body>
</html>
