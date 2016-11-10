<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/bootstrap-3.3.7/css/bootstrap.min.css">
    <link href="static/css/wcy.css" rel="stylesheet">
    <title>风险管理系统·登录</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
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
                <li class="active"><a href="/login">登录</a></li>
                <li><a href="/signup">注册</a></li>
                <li><a href="/secured">保密资源</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div>
    <form action="/qa-monitor/login" method="post" >
        <div class="form-group">
            <label class="">用户名</label>
            <input type="text" name="username">
        </div>
        <div class="form-group">
            <label class="">密码</label>
            <input type="password" name="password">
        </div>
        <input type="submit" class="btn btn-success " value="登陆">
        <input type="submit" class="btn btn-success " value="登陆">
    </form>
</div>
</body>
</html>
