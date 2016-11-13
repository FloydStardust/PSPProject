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
        <li role="presentation"><a href="/qa-monitor/home/risk_submited">创建的风险</a></li>
        <li role="presentation" class="active"><a href="javascript:;">跟踪的风险</a></li>
    </ul>
    <!-- Tab panes -->
    <div role="tabpanel">
        <table class="table">
            <thead>
            <tr>
                <th>项目名</th>
                <th>风险编号</th>
                <th>类型</th>
                <th>描述</th>
                <th>可能性</th>
                <th>影响程度</th>
                <th>风险标识</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><a>project</a></td>
                <td><a>project-34</a></td>
                <td>管理风险</td>
                <td>房产北京受到惩罚加快速度高哦啊接受到上帝啊</td>
                <td><span class="label label-danger">高</span></td>
                <td><span class="label label-warning">中</span></td>
                <td>风险</td>
                <td>
                    <button class="btn btn-info btn-xs" data-toggle="modal" data-target="#follow-risk-modal">风险跟踪</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <%-- 风险跟踪--%>
    <div class="modal fade" tabindex="-1" role="dialog" id="follow-risk-modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">风险跟踪</h4>
                </div>
                <div class="modal-body">
                    <form action="" method="post" id="follow-risk-form">
                        <div class="form-group">
                            <label for="risk-description">风险描述</label>
                            <input type="text" name="name" id="risk-description" class="form-control" >
                            <br>
                            <label for="change-orNot">是否成为问题</label>
                            <select id="change-orNot">
                                <option value="1" >是</option>
                                <option value="0" selected>否</option>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary" form="follow-risk-form">增加</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</main>
</body>
</html>
