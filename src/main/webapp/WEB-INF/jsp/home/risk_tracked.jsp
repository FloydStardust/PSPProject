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
    <link rel="stylesheet" href="/qa-monitor/static/jquery/jquery-confirm.min.css">
    <script src="/qa-monitor/static/jquery/jquery-confirm.min.js"></script>
    <title>风险管理系统·${user.name} 的主页</title>
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
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/qa-monitor/login">登录</a></li>
                <li><a href="/qa-monitor/signup">注册</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<main class="container">
    <h2>${user.name} 的主页</h2>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/qa-monitor/home/projects">创建的项目</a></li>
        <li role="presentation"><a href="/qa-monitor/home/risk_submited">提交的风险</a></li>
        <li role="presentation" class="active"><a href="javascript:;">跟踪的风险</a></li>
    </ul>
    <!-- Tab panes -->
    <div role="tabpanel">
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>风险名称</th>
                <th>所属项目</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>