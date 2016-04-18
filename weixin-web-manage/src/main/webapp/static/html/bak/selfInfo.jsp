<%--
  Created by IntelliJ IDEA.
  User: Cheng
  Date: 2016/3/28 0028
  Time: 12:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <title>个人信息</title>
</head>
<body>
<ol class="breadcrumb">
  <li><a href="index">首页</a></li>
  <li class="active">个人信息</li>
</ol>
<div id="main" class="container-fluid">
  <div class="row">
    <div class="col-md-3" style="text-indent: 40px;">
      <h3>头像</h3>
      <div class="thumbnail center-block" style="height: 200px; width: 200px;">
        <img src="${ctxStatic}/img/logo.jpg" alt="头像" style="height: 200px; width: 200px;">
      </div>
    </div>
    <div class="col-md-7">
      <div class="alert alert-success" role="alert"><strong>个人信息</strong></div>
      <table class="table table-striped">
        <colgroup>
          <col class="col-xs-2">
          <col class="col-xs-7">
        </colgroup>
        <tbody>
        <tr>
          <th>用 户 名：</th>
          <td>admin</td>
        </tr>
        <tr>
          <th>姓 名：</th>
          <td>--</td>
        </tr>
        <tr>
          <th>手 机 号：</th>
          <td>--</td>
        </tr>
        <tr>
          <th></th>
          <td></td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
</html>
