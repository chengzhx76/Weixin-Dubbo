<%--
  Created by IntelliJ IDEA.
  User: Cheng
  Date: 2016/3/28 0028
  Time: 11:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <title>个人信息编辑</title>
</head>
<body>
<ol class="breadcrumb">
  <li><a href="index">首页</a></li>
  <li class="active">个人信息编辑</li>
</ol>
<div id="main" class="container-fluid">
  <div class="row">
    <div class="col-md-3" style="text-indent: 20px;">
      <h3>头像</h3>
      <div class="thumbnail center-block" style="height: 200px; width: 200px;">
        <img src="${ctxStatic}/img/logo.jpg" alt="头像" style="height: 200px; width: 200px;">
      </div>
    </div>
    <div class="col-md-8">
      <div class="alert alert-warning" role="alert"><strong>不需要更改项，不必填写</strong></div>
      <form class="form-horizontal">
        <div class="form-group">
          <label for="username" class="col-sm-2 control-label">用户名：</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="username" value="admin" placeholder="用户名" readonly>
          </div>
        </div>
        <div class="form-group">
          <label for="realname" class="col-sm-2 control-label">真实名字：</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="realname" placeholder="真实名字">
          </div>
        </div>
        <div class="form-group">
          <label for="phone" class="col-sm-2 control-label">手机号：</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="phone" placeholder="手机号">
          </div>
        </div>
        <div class="form-group">
          <label for="password" class="col-sm-2 control-label">密码：</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" id="password" placeholder="密码">
          </div>
        </div>
        <div class="form-group">
          <label for="password2" class="col-sm-2 control-label">确认密码：</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" id="password2" placeholder="确认密码">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-info">更新个人资料</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
