<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录学生信息管理系统</title>
      <link rel="stylesheet" href="/sources/css/style.css">
      <link rel="icon" href="/sources/imgs/web.ico" type="image/x-icon">
  </head>
  <body>
    <div id="main-container">
        <div class="title">
            <span>账号登录</span>
        </div>
        <div class="from">
            <form id="login" action="/verify" method="post">
                <div class="id">
                    <div class="id-line">
                        <input id="id" type="text" name="id" placeholder="学号"/>
                    </div>
                </div>
                <div class="password">
                    <div class="password-line">
                        <input id="password" type="password" name="password" placeholder="密码"/>
                    </div>
                </div>
                <p>
                    <input type="submit" value="登录" id="submit">
                </p>
            </form>
        </div>
    </div>
  <script src="/sources/js/jquery.min.js"></script>
  <script src="/sources/js/login.js"></script>
  </body>
</html>
