<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="static/bootstrap-3.3.7/css/bootstrap.min.css">
    <link href="static/css/wcy.css" rel="stylesheet">
    <title>风险管理系统·注册</title>
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
                <li class="active"><a href="/qa-monitor/login">登录</a></li>
                <li><a href="/qa-monitor/signup">注册</a></li>
                <li><a href="/qa-monitor/secured">保密资源</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="main">
    <div class="login-form">
        <p class="form-title"> 注 册 </p>
        <form class="form-horizontal"  action="/qa-monitor/signup" method="post">
            <div class="form-group">
                <div class="">
                    <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
                </div>
            </div>
            <div class="form-group">
                <div class="">
                    <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
                </div>
            </div>
            <div class="form-group">
                <div class="">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <div class="">
                    <button type="submit" class="btn btn-success btn-block">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>