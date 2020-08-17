<%--
  Created by IntelliJ IDEA.
  User: InJamie
  Date: 2020/5/26
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
            height: 100%;
        }

        tr {
            background-color: #f9f9f9;
        }

        td {
            padding: 8px;
            line-height: 1.42857143;
            vertical-align: top;
            border-top: 1px solid #ddd;
        }

        a {
            text-decoration: none;
            color: black;
        }
    </style>


    <script>
        $(function () {

            //加载页面内容
            load(0);
            getonlineuser();

        });

        //==================获取当前用户信息并显示==================
        function getonlineuser() {
            $.post("findOnlineServlet", {}, function (data) {

                //{uid:1,name:'李四'}
                var msg = data.name;
                $("#name").html(msg);
            });
        }

        //==================删除帖子==================
        function deletepost(post_id, currentPage) {
            if (confirm("你确定要删除所选吗")) {
                $.get("deletePostServlet", {post_id: post_id});
                load(currentPage);
            }

        }

        //==================显示帖子内容、页码=========
        function load(currentPage) {
            var isadmin;
            $.get("findOnlineServlet", {}, function (data) {
                isadmin = data.admin;
            });

            $.get("getPagPostServlet", {currentPage: currentPage}, function (data) {
                //显示内容
                var posts = data.list;
                var tr = '    <tr><td>题目</td><td>内容</td><td>时间</td><td></td></tr>';

                //截取指定长度的内容
                posts[1].post_content.substring()

                //====================判断是否是管理员================
                if (isadmin == 1) {
                    for (var i = 0; i < posts.length; i++) {
                        var post = posts[i];
                        tr += '<tr class="post">' +
                            '<td><a href="post_detail.jsp?post_id=' + post.post_id + '">' + post.post_title + '</a></td>' +
                            '<td>' + post.post_content.substring(0, 20) + '......</td>' +
                            '<td>' + post.crete_time + '</td>' +
                            '<td>' + '<a class="btn btn-default" onclick="deletepost(' + post.post_id + ',' + currentPage + ')"  role="button">删除</a>' + '</td>' +
                            '</tr>\n'
                        $("#post_list").html(tr);
                    }
                } else {
                    for (var i = 0; i < posts.length; i++) {
                        var post = posts[i];
                        tr += '<tr class="post">' +
                            '<td><a href="post_detail.jsp?post_id=' + post.post_id + '">' + post.post_title + '</a></td>' +
                            '<td>' + post.post_content.substring(0, 20) + '......</td>' +
                            '<td>' + post.crete_time + '</td>' +
                            '<td></td>' +
                            '</tr>\n'
                        $("#post_list").html(tr);
                    }
                }

                //显示页码
                var total = data.totalCount;
                var totalpage = data.tatalPage;
                var str = '共' + total + '条帖子，共' + totalpage + '页。';
                $("#total").text(str);

                //======================================================
                //---------------------前一页------------------------
                var pagenum = data.currentPage - 1;
                var ss = '        <li>\n' +
                    '            <a onclick="javascript:load(' + pagenum + ')" aria-label="Previous">\n' +
                    '                <span aria-hidden="true">&laquo;</span>\n' +
                    '            </a>\n' +
                    '        </li>';
                //---------------------正常页码------------------------
                for (var i = 1; i <= totalpage; i++) {
                    var num = i - 1;
                    if (num == currentPage) {
                        ss += '<li class="active"><a onclick="load(' + (num) + ')">' + i + '</a></li>'
                    } else {
                        ss += '<li><a onclick="load(' + (i - 1) + ')">' + i + '</a></li>'
                    }
                }
                //---------------------下一页------------------------
                ss += '        <li>\n' +
                    '            <a onclick="load(' + (currentPage + 1) + ')" aria-label="Next">\n' +
                    '                <span aria-hidden="true">&raquo;</span>\n' +
                    '            </a>\n' +
                    '        </li>'
                //---------------------传值------------------------
                $("#list").html(ss);


            })
        }
    </script>
</head>
<body class="body-main">


<div style="width: 100%;font-size: 24px">
    <span>当前在线人数:${count}</span>
    <a class="btn btn-default" href="writepost.jsp" style="margin-left: 850px;font-size: 24px" role="button">写帖子</a>
    <span style="float: right"><span id="name"></span>欢迎你</span>
</div>


<table class="table table-striped  table-bordered  table-hover" id="post_list" style="margin-top: 20px"></table>
<h5><span id="total"></span></h5>
<nav aria-label="Page navigation">
    <ul class="pagination" id="list">

    </ul>
</nav>
</body>
</html>
