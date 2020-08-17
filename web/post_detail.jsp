<%--
  Created by IntelliJ IDEA.
  User: InJamie
  Date: 2020/6/3
  Time: 19:13
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
    <title>展示帖子</title>
    <script>
        $(function () {

            //展示当前登录用户
            $.post("findOnlineServlet", {}, function (data) {
                var msg = data.name;
                $("#name").html(msg);
            });


            //获取post_id   利用 GetQueryString 方法
            var post_id = GetQueryString("post_id");

            $("#postid").attr('value', post_id);


            $.get("detailPostServlet", {post_id: post_id}, function (data) {
                var title = data.post_title;
                var themeId = data.theme_id;
                var time = data.crete_time;
                var author = data.author;
                var content = data.post_content;


                $("#title").text(title);
                $("#type").text(themeId);
                $("#time").text(time);
                $("#author").text(author);
                $("#content").text(content);
            })


            //展示评论
            $.get("getCommentServlet", {post_id: post_id}, function (data) {
                var tr;
                for (var i = 0; i < data.length; i++) {
                    var comment = data[i];
                    tr += '<tr class="post"><td>' + comment.author + ':</td><td>' + comment.cotent + '</td><td>' + comment.createtime + '</td></tr>\n'
                    $("#post_list").html(tr);
                }
            })
        });

        function GetQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        }
    </script>

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
<span style="float: right;font-size: 24px"><span id="name"></span>欢迎你</span>
<a class="btn btn-default" href="list.jsp" role="button" style="float:right;    font-size: 17px;
    margin-right: 163px; ">返回列表</a>

<h1 id="title">标题栏</h1>
<div style="
    border-radius: 4px;
    height: 27px;
    font-size: 18px;
    padding-left: 20px;
    margin: 20px 0;
">
    类型:<span id="type">类型</span>
    <span id="time" style="margin: 0 40px;">时间</span>
    作者:<span id="author">作者</span>
</div>
<p style="font-size:20px;height: 300px" id="content">内容栏</p>

<%--评论盒子--%>
<table class="table table-striped " id="post_list" style="margin-top: 20px">

</table>

<%--评论表单--%>
<form action="commentServlet">
    <input type="input"
           name="postid"
           id="postid"
           value=""
           style="display: none"
    >
    <input placeholder="优质评论可以帮助作者获得更高的权重"
           class="form-control"
           name="comment"
           style="width: 800px;display: inline-block"
    >
    <button class="btn btn-default" type="submit">提交</button>
</form>
</body>
</html>
