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
    <script src="/qa-monitor/static/bootstrap-3.3.7/js/bootstrap.min.js"></script>
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
        <li role="presentation" class="active"><a href="javascript:;">创建的项目</a></li>
        <li role="presentation"><a href="/qa-monitor/home/risk_submited">提交的风险</a></li>
        <li role="presentation"><a href="/qa-monitor/home/risk_tracked">跟踪的风险</a></li>
    </ul>
    <!-- Tab panes -->
    <div role="tabpanel">
        <button class="btn btn-info" data-toggle="modal" data-target="#new-project-modal">新建</button>
        <table class="table">
            <thead>
            <tr>
                <th>#</th>
                <th>项目名称</th>
                <th>创建者</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${projects}" var="project">
                <tr>
                    <td>${project.id}</td>
                    <td><a href="/qa-monitor/projects/${project.id}">${project.name}</a></td>
                    <td>${project.creator.name}</td>
                    <td>
                        <button class="btn btn-danger btn-sm btn-delete" data-delete="${project.id}">删除</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%-- 新建项目 --%>
    <div class="modal fade" tabindex="-1" role="dialog" id="new-project-modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">新建项目</h4>
                </div>
                <div class="modal-body">
                    <form action="/qa-monitor/projects" method="post" id="new-project-form">
                        <div class="form-group">
                            <label for="project-name">项目名称</label>
                            <input type="text" name="name" id="project-name" class="form-control" placeholder="项目名...">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary" form="new-project-form">新建</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <script>
        $('#new-project-modal').on('shown.bs.modal', function () {
            $('#project-name').focus();
        });
        $('.btn-delete').on('click', function () {
            var id = this.dataset.delete;
            $.confirm({
                title: '确认删除?',
                backgroundDismiss: true,
                animationSpeed: 200,
                buttons: {
                    confirm: function () {
                        $.ajax('/qa-monitor/projects/' + id, {
                            method: 'DELETE',
                            success: function () {
                                window.location.reload();
                            },
                            error: function () {
                                $.alert('删除失败');
                            }
                        })
                    },
                    cancel: function () {
                    }
                }
            })
        })
    </script>
</main>
</body>
</html>
