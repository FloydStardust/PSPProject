<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <title>PRMS·风险详情</title>
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
            <a class="navbar-brand" href="/qa-monitor">项目风险管理系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/qa-monitor/home">我的主页</a></li>
                <sec:authorize access="isAuthenticated()">
                    <form class="navbar-form navbar-left" action="/qa-monitor/logout" method="post">
                        <button type="submit" class="btn">注销</button>
                    </form>
                </sec:authorize>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<main class="container">
    <div class="row title-div">
        <div class="title-name">
            <a href="/qa-monitor/projects/${risk.project.id}">${risk.project.name}</a> / ${risk.project.name}-${risk.id}
        </div >
        <div class="title-people">
            创建者：${risk.creator.name} &nbsp;&nbsp;&nbsp;
            跟踪者：${risk.tracker.name}
        </div>
    </div>
    <div class="row">
        <br>
        <fieldset class="risk-detail">
            <legend class="font-weight-b">详情</legend>
            <div class="rd-content">
                <div class="font-weight-b">
                    风险描述：${risk.description}
                </div>
                <div>
                    <div class="font-16 ft-fml">
                        类型 : ${risk.type.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                        可能性 :
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
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                        影响程度 :
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
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                        状态 :
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
                    </div>
                </div>
                <div>
                    触发器/阈值：${risk.threshold}
                </div>
                <div>
                    风险应对措施：${risk.action}
                </div><br>
                <div>
                        <form action="/qa-monitor/projects/${risk.project.id}/risks/${risk.id}/close" method="post" >
                            <button type="submit"  class="btn btn-danger btn-sm">关闭该风险</button>
                        </form>
                        <button class="btn btn-info btn-sm" data-toggle="modal" data-target="#change-risk-modal">修改风险内容</button>
                        
                </div>
            </div>
        </fieldset>
        <fieldset class="risk-detail">
            <div class="risk-detail-title font-weight-b">状态跟踪记录</div>
            <div>
                <c:choose>
                    <c:when test="${user.name==risk.tracker.name}">
                        <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#follow-risk-modal">风险跟踪</button>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </div>
            <table class="table table-hover table-striped">
                <tbody>
                <c:forEach items="${trackRecords}" var="trackRecord">
                    <tr>
                        <td>
                            <div class="layout-m2">
                                <div class="font-18 ">${risk.tracker.name} 更新了 ${risk.project.name}-${risk.id} 风险状态</div>
                                <c:choose>
                                    <c:when test="${trackRecord.happened==true}">
                                        <div class="p-risk-dis">
                                            <div class="font-16 ft-fml">将状态从风险改为问题</div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                    </c:otherwise>
                                </c:choose>
                                <div class="p-risk-dis">
                                    <div class="font-16 ft-fml">${trackRecord.description}</div>
                                </div>
                                <div class="font-12">${trackRecord.createdAt}</div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <div class="layout-m1">
                        <div class="font-18 ">${risk.creator.name} 创建了  ${risk.project.name}-${risk.id}  风险</div>
                        <div class="font-12">${risk.createdAt.toString()}</div>
                    </div>
                </tr>
                </tbody>
            </table>
        </fieldset>
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
                    <form action="/qa-monitor/risks/${risk.id}/track" method="post" id="follow-risk-form">
                        <div class="form-group">
                            <label for="risk-description">状态</label>
                            <input type="text" name="description" id="risk-description" class="form-control" >
                            <br>
                            <label for="change-orNot">是否成为问题</label>
                            <label class="checkbox-inline">
                                <input type="radio" name="happened" id="optionsRadios1" value="false" checked>否
                                <input type="radio" name="happened" id="optionsRadios2" value="true">是
                            </label>
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

    <%-- 风险修改--%>
    <div class="modal fade" tabindex="-1" role="dialog" id="change-risk-modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">风险修改</h4>
                </div>
                <div class="modal-body">
                    <form action="/qa-monitor/projects/${risk.project.id}/risks/${risk.id}/update" method="post" id="change-risk-form">
                        <div class="form-group">
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
                                    <input type="text" name="threshold" id="risk-trigger" class="form-control" placeholder="${risk.threshold}">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary" form="change-risk-form">修改</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</main>
</body>
</html>