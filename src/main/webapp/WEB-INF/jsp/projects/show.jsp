<%@ page import="com.psp.entity.RoleType" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.psp.entity.RiskType" %><%--
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
            风险管理系统
        </div >
        <div class="title-people">
            创建者：ly1996
        </div>
    </div>
    <div class="row">
        <br>
        <div class="col-md-2">
            <ul class="nav nav-tabs nav-stacked">
                <li role="presentation" class="active"><a href="#home" data-toggle="tab">首页</a></li>
                <li role="presentation"><a href="#risk" data-toggle="tab">风险</a></li>
            </ul>
        </div>
        <div class="col-md-10 tab-content">
            <div class="tab-pane fade in active row" id="home">
                <div class="col-md-8 div-border">
                    <h3 class="dash-title">最新动态</h3>
                    <div class="layout-m1">
                        <div class="font-18 ">ly1996 创建了 <a>project-02</a> 风险</div>
                        <div class="p-risk-dis">
                            <div class="font-16 ft-fml">类型 : 范围风险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可能性 : 高&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;影响程度 : 中</div>
                            <div class="font-16 ft-fml">风险描述：快递费设为维护费稳定客户hi我都不玩空间非常
                                鲍斯股份你参加考试大部分可接受的</div>
                        </div>
                        <div class="font-12">2012-2-34 12:00</div>
                    </div>
                    <div class="layout-m1">
                        <div class="font-18 ">ly1996 更新了 <a>project-01</a> 风险状态</div>
                        <div class="p-risk-dis">
                            <div class="font-16 ft-fml">风险描述快递费设为维护费稳定客户hi我都不玩空间非常
                                鲍斯股份你参加考试大部分可接受的</div>
                        </div>
                        <div class="font-12">2012-2-34 12:00</div>
                    </div>
                    <div class="layout-m1">
                        <div class="font-18 ">ly1996 创建了 <a>project-01</a> 风险</div>
                        <div class="p-risk-dis">
                            <div class="font-16 ft-fml">类型 : 范围风险&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可能性 : 高&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;影响程度 : 中</div>
                            <div class="font-16 ft-fml">风险描述：快递费设为维护费稳定客户hi我都不玩空间非常
                                鲍斯股份你参加考试大部分可接受的</div>
                        </div>
                        <div class="font-12">2012-2-34 12:00</div>
                    </div>

                </div>
                <div class="col-md-4 div-border-top">
                    <div class="member-div"><span class="font-20 ft-fml">项目成员</span><button
                            class="btn btn-sm btn-info float-right" data-toggle="modal" data-target="#add-member-modal">添加成员</button></div>
                    <ul>
                        <li>
                            <h4>项目经理</h4>
                            <h5>wcy<button class="btn btn-xs btn-link float-right">移除</button></h5>
                        </li>
                        <li>
                            <h4>
                                开发人员
                            </h4>
                            <h5>karry<button class="btn btn-xs btn-link float-right">移除</button></h5>
                            <h5>roy<button class="btn btn-xs btn-link float-right">移除</button></h5>

                        </li>
                    </ul>
                </div>
                <%-- 添加成员 --%>
                <div class="modal fade" tabindex="-1" role="dialog" id="add-member-modal">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">添加成员</h4>
                            </div>
                            <div class="modal-body">
                                <form action="" method="post" id="add-member-form">
                                    <div class="form-group">
                                        <label for="member-select">成员选择</label>
                                        <select id="member-select">
                                            <option value="1">wcy1995</option>
                                            <option value="2">ly1996</option>
                                        </select>
                                        <label for="identity-select">身份选择</label>
                                        <select id="identity-select">
                                            <c:forEach items="${roleTypes}" var="roleType">
                                                <option value=${roleType.toString()}>${roleType.toString()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="submit" class="btn btn-primary" form="add-member-form">增加</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </div>
            <div class="tab-pane fade" id="risk">
                <button class="btn btn-info crt-btn" data-toggle="modal" data-target="#create-risk-modal">新建风险</button>
                <table class="table">
                    <thead>
                    <tr>
                        <th>风险编号</th>
                        <th>类型</th>
                        <th>描述</th>
                        <th>可能性</th>
                        <th>影响程度</th>
                        <th>当前状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${risks}" var="risk">
                        <tr>
                            <td><a>${risk.id}</a></td>
                            <td>${risk.type.toString()}</td>
                            <td>${risk.description}</td>
                            <td>${risk.probability}</td>
                            <td>${risk.impact}</td>
                            <%
                                if(risk.happened)
                                {
                            %>
                            <td>风险</td>
                            <%
                                }else
                                {
                            %>
                            <td>问题</td>
                            <%
                                }
                            %>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <%-- 风险创建--%>
            <div class="modal fade" tabindex="-1" role="dialog" id="create-risk-modal">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">风险创建</h4>
                        </div>
                        <div class="modal-body">
                            <form action="" method="post" id="create-risk-form">
                                <div class="form-group">
                                    <label for="risk-type">风险类型</label>
                                    <select id = "risk-type" name = "riskTypeId">
                                        <c:forEach items="${riskTypes}" var="type">
                                            <option value=${type.toString()}>${type.toString()}</option>
                                        </c:forEach>
                                    </select>
                                    <br/>
                                    <label for="risk-description">风险描述</label>
                                    <input type="text" name="description" id="risk-description" class="form-control" placeholder="...">
                                    <br/>
                                    <label for="follower">跟踪者</label>
                                    <select id = "follower" name = "trackerId">
                                        <c:forEach items="${roles}" var="role">
                                            <option value=${role.user.name}>${role.user.name}</option>
                                        </c:forEach>
                                    </select>
                                    <br/>
                                    <label for="possibility">可能性</label>
                                    <select id = "possibility" name = "probability">
                                        <option value = "LOW">低</option>
                                        <option value = "MEDIUM">中</option>
                                        <option value="HIGH">高</option>
                                    </select>
                                    <br/>
                                    <label for="affect">影响程度</label>
                                    <select id = "affect" name = "impact">
                                        <option value = "LOW">低</option>
                                        <option value = "MEDIUM">中</option>
                                        <option value="HIGH">高</option>
                                    </select>
                                    <br/>
                                    <label for="risk-trigger">触发器</label>
                                    <input type="text" name="threshold" id="risk-trigger" class="form-control" placeholder="...">
                                    <br/>
                                    <label for="risk-measure">风险应对措施</label>
                                    <input type="text" name="action" id="risk-measure" class="form-control" placeholder="...">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="submit" class="btn btn-primary" form="create-risk-form">增加</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        </div>
    </div>
</main>
</body>
</html>