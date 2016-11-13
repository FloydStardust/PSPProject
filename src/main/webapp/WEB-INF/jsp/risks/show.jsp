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

    <link href="/qa-monitor/static/css/wcy.css" rel="stylesheet">
    <link href="/qa-monitor/static/css/ly.css" rel="stylesheet">
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
    <div class="row title-div">
        <div class="title-name">
            <a>风险管理系统</a> / 风险管理系统-1
        </div >
        <div class="title-people">
            创建者：ly1996 &nbsp;&nbsp;&nbsp;
            跟踪者：karry
        </div>
    </div>
    <div class="row">
        <br>
        <fieldset class="risk-detail">
            <legend class="font-weight-b">详情</legend>
            <div class="rd-content">
                <div class="font-weight-b">
                    风险描述：技术人员离职会对项目的开发造成影响
                </div>
                <div>
                    <div class="font-16 ft-fml">
                        类型 : 进度风险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        可能性 : <span class="label label-warning">中</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        影响程度 : <span class="label label-danger">高</span>
                    </div>
                </div>
                <div>
                    触发器/阈值：某技术人员提交离职申请
                </div>
                <div>
                    风险应对措施：在未变成问题前无需关心；在变成问题后从xx技术部门紧急调派技术人员
                </div>
            </div>
        </fieldset>
        <fieldset class="risk-detail">
            <div class="risk-detail-title font-weight-b">状态跟踪记录</div>
            <table class="table table-hover table-striped">
                <tbody>
                <tr>
                    <td>
                        <div class="layout-m2">
                            <div class="font-18 ">ly1996 更新了 project-01 风险状态</div>
                            <div class="p-risk-dis">
                                <div class="font-16 ft-fml">将状态从风险改为问题</div>
                            </div>
                            <div class="font-12">2012-2-34 12:00</div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="layout-m2">
                            <div class="font-18 ">ly1996 更新了 project-01 风险状态</div>
                            <div class="p-risk-dis">
                                <div class="font-16 ft-fml">风险描述快递费设为维护费稳定客户hi我都不玩空间非常
                                    鲍斯股份你参加考试大部分可接受的</div>
                            </div>
                            <div class="font-12">2012-2-34 12:00</div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="layout-m2">
                            <div class="font-18 ">ly1996 创建了 project-01 风险</div>
                            <div class="p-risk-dis">
                                <div class="font-16 ft-fml">
                                    类型 : 进度风险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    可能性 : 中&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    影响程度 : 高
                                </div>
                                <div class="font-16 ft-fml">风险描述：快递费设为维护费稳定客户hi我都不玩空间非常
                                    鲍斯股份你参加考试大部分可接受的</div>
                            </div>
                            <div class="font-12">2012-2-34 12:00</div>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </div>
</main>
</body>
</html>