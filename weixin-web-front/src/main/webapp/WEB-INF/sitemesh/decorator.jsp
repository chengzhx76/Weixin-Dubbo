<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>微信管理后台-<sitemesh:title/></title>
    <link href="${ctxStatic}/css/bootstrap.css" rel="stylesheet">
    <link href="${ctxStatic}/css/global.css" rel="stylesheet">
    <sitemesh:head/>
</head>
<body>
    <!-- 导航栏Start -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="" class="navbar-header">
                    <img src="${ctxStatic}/img/logo.jpg" style="width:75px">
                </a>
            </div>
            <div><p class="navbar-text">微信 管理后台</p></div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-home"></span> 网站首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span> admin <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="myinfo"><span class="glyphicon glyphicon-th-list"></span> 资料</a></li>
                            <%--<li><a href="selfedit"><span class="glyphicon glyphicon-cog"></span> 设置</a></li>--%>
                            <li class="divider"></li>
                            <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- 导航栏End -->
    <!-- 侧边栏开始 -->
    <div id="main" class="container-fluid">
        <div class="row">
            <div class="col-md-2">
                <div id="main-nav" class="panel-group" role="tablist">
                    <div class="panel panel-primary">
                        <div class="panel-heading" role="tab">
                            <h4 class="panel-title">
                                <a href="index">首页</a>
                            </h4>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="collapseList1">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne" style="display:block">系统管理</a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseList1" aria-expanded="true">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="user/users" style="display:block">用户管理</a></li>
                                <li class="list-group-item"><a href="groups" style="display:block">群组管理</a></li>
                            </ul>
                            <div class="panel-footer"></div>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="collapseList2">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo" style="display:block">管理员管理</a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseList2" aria-expanded="true">
                            <ul class="list-group">
                                <li class="list-group-item"><a href="admin/admins" style="display:block">管理员列表</a></li>
                            </ul>
                            <div class="panel-footer"></div>
                        </div>
                    </div>
                </div><!-- panel-group -->
            </div><!-- col-md-2 -->
            <!-- 侧边栏End -->

            <!-- 主要内容Start -->
            <section id="main-content" class="center-block col-md-10">
                <sitemesh:body/>
            </section>
            <!-- 主要内容End -->

        </div><!-- row -->
    </div><!-- container-fluid -->

    <footer class="container-fluid">
        <div class="navbar navbar-default navbar-fixed-bottom" role="navigation">
            <p class="text-center">Copyright  &copy; 2015 麒麟岛</p>
        </div>
    </footer>

    <script src="${ctxStatic}/js/jquery-1.11.1.min.js"></script>
    <script src="${ctxStatic}/js/bootstrap.js"></script>
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</body>
</html>