<%--
  Created by IntelliJ IDEA.
  User: InJamie
  Date: 2020/6/3
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="js/bootstrap.js"></script>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="js/jquery-3.2.1.min.js"></script>
<html>
<head>
    <title>写帖子</title>

    <style>
        html {
            padding: 20px;
        }

        body {
            padding: 20px;
            box-shadow: 7px 7px 20px rgba(0, 0, 0, 0.3);
            height: 100%;
        }
    </style>
</head>
<body>
<form action="writePostServlet" method="post" style="width: 760px;
    margin: 0 auto;
">
    <h1 style="display: inline-block">写下你的分享...</h1>
    <a class="btn btn-default" href="list.jsp" role="button" style="float:right;    font-size: 17px;
    margin-right: 163px;margin: 25px;    ">返回列表</a>

    <input type="text" class="form-control" placeholder="写下标题" name="post_title" style="margin: 20px 0;">
    <textarea class="form-control" rows="5" style="margin-bottom: 20px" name="content"></textarea>
    <%--    帖子类型--%>
    <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="1"> 原创
    </label>
    <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="2"> 转载
    </label>
    <label class="radio-inline">
        <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="3"> 分享
    </label>

    <button class="btn btn-default" type="submit" style="float: right">发表帖子</button>
</form>

</body>
</html>
