<%--
  Created by IntelliJ IDEA.
  User: InJamie
  Date: 2020/5/26
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
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

        .form-horizontal {
            width: 597px;
            margin: 125px auto;
        }

        .body-main {
            padding: 20px;
            box-shadow: 7px 7px 20px rgba(0, 0, 0, 0.3);
            height: 682px;
            position: relative;
        }

        #inputCheckCode {
            width: 130px;
            display: inline-block;

        }

        h2 {
            display: block;
            margin: 70px 54px 0;
            font-weight: 600;
            text-align: right;
        }

        .form-main {
            width: 597px;
            margin: 35px 57px;
            display: inline-block;
            position: absolute;
            right: 0;
        }

        #checkbox_main {
            font-weight: 600;
            margin-left: 30px;

        }

        .register {
            border: 1px #37B9E9 solid;
            border-radius: 4px;
            background-color: #37B9E9;
            width: 478px;
            height: 60px;
            font-weight: lighter;
            margin: 38px -30px 8px;
            font-size: 24px;
            color: #fff;
        }
    </style>

    <script>
        /*
				表单校验：
					1.用户名：单词字符，长度8到20位
					2.密码：单词字符，长度8到20位
					3.email：邮件格式
					4.姓名：非空
					5.手机号：手机号格式
					6.性别：默认男
					7.验证码：非空
			 */

        //校验用户名
        //单词字符，长度8到20位
        function checkusername() {
            //获取用户名
            var username = $("#username").val();
            //定义正则表达式
            var reg_username = /^\w{8,20}/;
            //判断验证
            var flag = reg_username.test(username);
            if (flag) {
                //姓名合法去除边框
                $("#username").css("border", "");
            } else {
                //姓名不合法 添加红色边框
                $("#username").css("border", "1.5px solid red");
                $("#errorMsg").text("请输入8~20位字符账号。")

            }

            return flag;

        }

        //校验密码
        function checkPassword() {
            //1.获取密码值
            var password = $("#password").val();
            //2.定义正则
            var reg_password = /^\w{8,20}$/;

            //3.判断，给出提示信息
            var flag = reg_password.test(password);
            if (flag) {
                //密码合法
                $("#password").css("border", "");
            } else {
                //密码非法,加一个红色边框
                $("#password").css("border", "1.5px solid red");
                $("#errorMsg").text("请输入8~20位字符密码。")

            }

            return flag;
        }

        //校验电话号码
        function checkNumber() {
            //1.获取电话号码
            var number = $("#inputPhone").val();
            //2.定义正则表达式   11位数字
            var reg_num = /^[0-9]{11}$/;
            //3.判断
            var flag = reg_num.test(number);

            if (flag) {
                $("#inputPhone").css("border", "");
            } else {
                $("#inputPhone").css("border", "1.5px solid red");
                $("#errorMsg").text("请输入正确手机号。")

            }

            return flag;
        }

        //校验邮箱
        function checkEmail() {
            //1.获取邮箱
            var email = $("#email").val();
            //2.定义正则		itcast@163.com
            var reg_email = /^\w+@\w+\.\w+$/;

            //3.判断
            var flag = reg_email.test(email);
            if (flag) {
                $("#email").css("border", "");
            } else {
                $("#email").css("border", "1.5px solid red");
                $("#errorMsg").text("请输入正确邮箱号。")

            }

            return flag;
        }

        $(function () {
            //当表单提交时，调用所有的校验方法
            $("#registerForm").submit(function () {
                //1.发送数据到服务器

                if (checkusername() && checkPassword() && checkEmail()) {
                    //校验通过,发送ajax请求，提交表单的数据   username=zhangsan&password=123
                    $.post("registerServlet", $(this).serialize(), function (data) {
                        //处理服务器响应的数据  data  {flag:true,errorMsg:"注册失败"}
                        if (data.flag) {
                            //注册成功，跳转成功页面
                            location.href = "register_ok.jsp";
                        } else {
                            //注册失败,给errorMsg添加提示信息
                            $("#errorMsg").text(data.errorMsg);
                        }
                    });

                }
                //2.不让页面跳转
                $("#checkcode").html("${pageContext.request.contextPath}/checkCodeServlet");
                return false;
                //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交
            });
            //提交表单校验


            //当某一个组件失去焦点是，调用对应的校验方法
            $("#username").blur(checkusername);
            $("#password").blur(checkPassword);
            $("#email").blur(checkEmail);
            $("#inputPhone").blur(checkNumber);

        });


    </script>

</head>
<body class="body-main">
<%--<img src="img/backgroud.jpg" alt="" style="position: absolute;--%>
<%--    top: 0;--%>
<%--    left: 0;--%>
<%--    width: 723px;--%>
<%--    border-radius: 4px;">--%>
<div style="
width: 723px;
height: 100%;
position: absolute;
top: 0;
left: 0;
border-radius: 4px;
font-weight: 100;
background-image: linear-gradient(to right, #9ABEB5 , #37B9E9);
">
    <span style="color: white;font-size: 56px;top: 100px;font-weight: 400;
left: 35px;position: absolute">海内存知己，天涯若比邻。</span>

</div>
<h2>现在就加入BBS。</h2>
<form class="form-horizontal form-main" id="registerForm">
    <div id="errorMsg" style="position: absolute;
    position: absolute;
    right: 0;
    top: 285px;
    width: 165px;
    height: 50px;
    color:red;
    text-align: center"></div>

    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">账号</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="username" placeholder="请输入账号" name="username">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="email" placeholder="请输入Email" name="email">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" placeholder="请输入真实姓名" name="name">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">手机号</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputPhone" placeholder="手机号码" name="number">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">性别</label>
        <div class="col-sm-10">
            <input type="radio" id="sex" name="gender" value="男" checked=""> 男
            <input type="radio" name="gender" value="女"> 女
        </div>
    </div>

    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">验证码</label>
        <div class="col-sm-10">
            <input type="text" autocomplete=off class="form-control" id="inputCheckCode" name="checkcode">
            <img style="margin: 10px 80px" src="${pageContext.request.contextPath}/checkCodeServlet"
                 onclick="changeCheckCode(this)" id="checkcode" alt="">
            <script type="text/javascript">
                //图片点击事件
                function changeCheckCode(img) {
                    img.src = "checkCodeServlet?" + new Date().getTime();
                }
            </script>
        </div>
    </div>
    <div class="checkbox">
        <label id="checkbox_main">
            <input type="checkbox"> 我已阅读并同意相关服务条款和隐私政策
        </label>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="submit" class="register btn" value="立即注册">
        </div>
    </div>
</form>
</body>
</html>
