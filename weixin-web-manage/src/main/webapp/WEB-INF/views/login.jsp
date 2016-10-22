<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <title>微信管理后台 - 登录</title>
  <meta name="keywords" content="微信管理后台">
  <meta name="description" content="基于电商平台">
  <link href="${ctxStatic}/css/bootstrap.min.css" rel="stylesheet">
  <link href="${ctxStatic}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
  <link href="${ctxStatic}/css/animate.min.css" rel="stylesheet">
  <link href="${ctxStatic}/css/plugins/toastr/toastr.min.css" rel="stylesheet">
  <link href="${ctxStatic}/css/style.min.css" rel="stylesheet">
  <link href="${ctxStatic}/css/login.min.css" rel="stylesheet">
  <!--[if lt IE 9]>
  <meta http-equiv="refresh" content="0;ie.html" />
  <![endif]-->
</head>

<body class="signin">
<div class="signinpanel">
  <div class="row">
    <div class="col-sm-7">
      <div class="signin-info">
        <div class="logopanel m-b">
          <h1>[ WeiXin-Shop ]</h1>
        </div>
        <div class="m-b"></div>
        <h4>欢迎使用 <strong>微信管理后台</strong></h4>
        <ul class="m-b">
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
          <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
        </ul>
        <!--<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>-->
      </div>
    </div>
    <div class="col-sm-5">
      <form action="${basePath}/login" method="post">
        <h4 class="no-margins">登录：</h4>
        <p class="m-t-md">登录到微信管理后台</p>
        <input type="text" class="form-control m-b uname" name="username" required value="${username}" placeholder="用户名" />
        <input type="password" class="form-control m-b pword" name="password" required placeholder="密码" />
        <c:if test="${isValidateCodeLogin}">
          <sys:captcha name="captcha"/>
        </c:if>
        <a href="#">忘记密码了？</a>
        <button class="btn btn-success btn-block">登录</button>
      </form>
    </div>
  </div>
  <div class="signup-footer">
    <div class="pull-left">
      Copyright &copy; 2015-2016 <a href="###">微信管理后台</a> Powered By Wxin v0.1
    </div>
  </div>
</div>

<script src="${ctxStatic}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctxStatic}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${ctxStatic}/js/plugins/toastr/toastr.min.js"></script>
<script >
  $(function() {
    var msg = "用户名或密码错误.";
    var title = "";
    var $showDuration = "400"; // 持续时间
    var $hideDuration = "1000"; //隐藏持续时间
    var $timeOut = "7000"; // 超时
    var $extendedTimeOut = "1000" // 延长时
    var $showEasing = "swing"; // 显示动画
    var $hideEasing = "linear"; // 隐藏动画
    var $showMethod = "fadeIn"; // 显示方法
    var $hideMethod = "fadeOut"; // 隐藏方法
    toastr.options = {
      closeButton: true,
      debug: false,
      progressBar: true,
      positionClass: "toast-top-right",
      onclick: null
    };
    toastr.options.showDuration = $showDuration
    toastr.options.hideDuration = $hideDuration
    toastr.options.timeOut = $timeOut
    toastr.options.extendedTimeOut = $extendedTimeOut
    toastr.options.showEasing = $showEasing
    toastr.options.hideEasing = $hideEasing
    toastr.options.showMethod = $showMethod
    toastr.options.hideMethod = $hideMethod
    toastr["success"](msg, title);
  });
</script>
</body>
</html>
