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
    <link href="/qa-monitor/static/css/wcy.css" rel="stylesheet">
    <script src="/qa-monitor/static/jquery/jquery-3.1.1.min.js"></script>
    <script src="/qa-monitor/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
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
            <a class="navbar-brand" href="/qa-monitor">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/qa-monitor/login">登录</a></li>
                <li><a href="/qa-monitor/signup">注册</a></li>
                <li class="active"><a href="/qa-monitor/home">用户主页</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="/qa-monitor/logout" method="post">
                <button type="submit" class="btn">注销</button>
            </form>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<main class="container">
    <h2>${user.name} 的主页</h2>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="/qa-monitor/home/projects">我的项目</a></li>
        <li role="presentation" class="active"><a href="javascript:;">创建的风险</a></li>
        <li role="presentation"><a href="/qa-monitor/home/risk_tracked">跟踪的风险</a></li>
    </ul>
    <!-- Tab panes -->
    <div role="tabpanel">
        <table class="table">
            <thead>
            <tr>
                <th>项目名</th>
                <th>#</th>
                <th>类型</th>
                <th>描述</th>
                <th>可能性</th>
                <th>影响程度</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${risks}" var="risk">
                <tr>
                    <td><a href="/qa-monitor/projects/${risk.project.id}">${risk.project.name}</a> </td>
                    <td><a href="/qa-monitor/projects/${risk.project.id}/risks/${risk.id}">${risk.project.name}-${risk.id}</a></td>
                    <td>${risk.type.name}</td>
                    <td>${risk.description}</td>
                    <td>
                        <c:choose>
                            <c:when test="${risk.probability=='HIGH'}">
                                <span class="label label-danger">高</span>
                            </c:when>
                            <c:when test="${risk.probability=='MEDIUM'}">
                                <span class="label label-warning">中</span>
                            </c:when>
                            <c:otherwise>
                                <span class="label label-info">低</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${risk.impact=='HIGH'}">
                                <span class="label label-danger">高</span>
                            </c:when>
                            <c:when test="${risk.impact=='MEDIUM'}">
                                <span class="label label-warning">中</span>
                            </c:when>
                            <c:otherwise>
                                <span class="label label-info">低</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${risk.happened==true}">
                                问题
                            </c:when>
                            <c:otherwise>
                                风险
                            </c:otherwise>
                        </c:choose>
                        &nbsp;&nbsp;
                        <c:choose>
                            <c:when test="${risk.closed==true}">
                                <span class="label label-default">已关闭</span>
                            </c:when>
                            <c:otherwise>
                                <span class="label label-success">开放中</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>
