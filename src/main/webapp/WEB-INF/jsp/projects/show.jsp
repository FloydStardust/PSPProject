<%--
  Created by IntelliJ IDEA.
  User: jankin
  Date: 11/11/2016
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/qa-monitor/static/bootstrap-3.3.7/css/bootstrap.min.css">
    <script src="/qa-monitor/static/jquery/jquery-3.1.1.min.js"></script>
    <script src="/qa-monitor/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="/qa-monitor/static/js/home.js"></script>
    <title>风险管理系统·项目详情</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/qa-monitor">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/qa-monitor/login">登录</a></li>
                <li><a href="/qa-monitor/signup">注册</a></li>
                <li><a href="/qa-monitor/home">用户主页</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="/qa-monitor/logout" method="post">
                <button type="submit" class="btn">注销</button>
            </form>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<main class="container">
    <h2>${project.id}</h2>
    <h2>${project.name}</h2>
    <h3>${project.creator.name}</h3>
</main>
</body>
</html>
