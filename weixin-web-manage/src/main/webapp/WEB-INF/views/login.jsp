<%--
  Created by IntelliJ IDEA.
  User: 光灿
  Date: 2016/1/24
  Time: 10:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>微信后台-登录</title>
  <link href="${ctxStatic}/css/bootstrap.css" rel="stylesheet">
  <link href="${ctxStatic}/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div id="messageBox">
    <div class="center-block alert alert-danger alert-dismissible ${empty message ? "hidden" : ""}" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      <label id="loginError" class="error">${message}</label>
    </div>
  </div>
  <header>
    <h2 class="text-center">微信管理后台登录</h2>
  </header>
  <section class="loginBox center-block">
    <ul class="nav nav-tabs" role="tablist">
      <li role="presentation" class="active">
        <a href="#form" aria-controls="form" role="tab" data-toggle="tab">帐号登录</a>
      </li>
      <li role="presentation">
        <a href="#wxscan" aria-controls="scan" role="tab" data-toggle="tab">微信扫描登录</a>
      </li>
    </ul>

    <div class="tab-content">
      <div role="tabpanel" class="tab-pane active" id="form">
        <%--<form action="${basePath}/login" method="post">--%>
        <form id="loginForm" action="" method="post">
          <div class="form-group">
            <label for="username">登录名：</label>
            <input type="text" class="form-control" name="username" id="username" required placeholder="Username" value="${username}">
          </div>
          <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" class="form-control" name="password" id="password" required placeholder="Password">
          </div>
          <c:if test="${isValidateCodeLogin}">
            <sys:validateCode name="captcha" inputCssStyle="margin-bootom:0;"/>
          </c:if>
          <hr/>
          <input id="submit" class="btn btn-primary" type="submit" value="登陆"> &nbsp;&nbsp;
          <label for="rememberMe" title="下次不需要再登录">
            <input type="checkbox" id="rememberMe" name="rememberMe"> 记住我（公共场所慎用）
          </label>
        </form>
      </div>
      <div role="tabpanel" class="tab-pane" id="wxscan">
        <img src="${ctxStatic}/img/weixin_login.jpg" alt="扫描登陆" class="img-responsive img-thumbnail">
      </div>
    </div>
  </section>
  <footer>
    <h5 class="text-center">Copyright &copy; 2015-2016 <a href="###">微信管理后台</a> Powered By Wxin v0.1</h5>
  </footer>
</div>

<script src="${ctxStatic}/js/jquery-1.11.1.min.js"></script>
<script src="${ctxStatic}/js/bootstrap.js"></script>
<script src="${ctxStatic}/js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(function(){
});
</script>
</body>
</html>
