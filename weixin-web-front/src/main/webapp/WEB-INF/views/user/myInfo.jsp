<%--
  Created by IntelliJ IDEA.
  User: Cheng
  Date: 2016/3/28 0028
  Time: 16:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <title>个人信息</title>
  <style>
    em {
      font-style: normal;
    }
    a:focus {
      outline: none;
    }
    .alert {
      height: 30px;
      width: 50%;
      margin: 1px 0 10px 0px;
      line-height: 1px;
    }
    h3 {
      text-indent: 40px;
    }
    .thumbnail {
      height: 200px;
      width: 200px;
    }
    .form-control {
      width: 320px;
    }
    .form-horizontal {
      width: 85%;
    }
    strong.readonly {
      width: 17%;
      height: 20px;
      line-height: 20px;
      text-align: right;
      padding-right: 17px;
      margin-right: 15px;
      display: inline-block;
    }
  </style>
</head>
<body>
  <ol class="breadcrumb">
    <li><a href="index">首页</a></li>
    <li class="active">个人信息</li>
  </ol>
  <div id="main" class="container-fluid">
    <div class="row">
      <div class="col-md-3">
        <h3>头像</h3>
        <div class="thumbnail center-block">
          <img src="${ctxStatic}${admin.photo}" alt="头像" height="200px" width="200px">
        </div>
      </div>
      <div class="col-md-9">
        <ul id="myInfoTab" class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active">
            <a href="#myInfo" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">个人信息</a>
          </li>
          <li role="presentation" class="">
            <a href="#modifyPwd" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile" aria-expanded="false">修改密码</a>
          </li>
        </ul>
        <div id="myTabContent" class="tab-content">
          <div role="tabpanel" class="tab-pane fade active in" id="myInfo" aria-labelledby="myInfo-tab">
            <div class="alert alert-warning" role="alert"><strong>不需要更改项，不必修改</strong></div>
            <form class="form-horizontal">
              <!--
              <div class="form-group">
                <strong class="readonly">用户名：</strong><span>admin</span>
              </div>
              -->
              <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名：</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="username" value="${admin.username}" placeholder="用户名" readonly>
                </div>
              </div>

              <div class="form-group">
                <label for="realname" class="col-sm-2 control-label">真实名字：</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="realname" value="${admin.realname}" placeholder="真实名字">
                </div>
              </div>
              <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">手机号：</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="phone" value="${admin.mobile}" placeholder="手机号">
                </div>
              </div>
              <div class="form-group">
                <label for="remarks" class="col-sm-2 control-label">备注：</label>
                <div class="col-sm-10">
                  <textarea  class="form-control" rows="3" id="remarks" placeholder="备注">${admin.remarks}</textarea>
                </div>
              </div>
              <div class="form-group">
                <strong class="readonly">用户角色：</strong><span>公司管理员，系统管理员</span>
              </div>
              <div class="form-group">
                <strong class="readonly">${empty admin.oldLoginIp ? "本" : "上"}次登录：</strong>
                <em>IP：</em><span> ${empty admin.oldLoginIp ? admin.loginIp : admin.oldLoginIp}</span>&nbsp;&nbsp;&nbsp;&nbsp;
                <em>时间：</em><time><fmt:formatDate value="${empty admin.oldLoginDate ? admin.loginDate : admin.oldLoginDate}" type="both" dateStyle="full" timeStyle="short"/></time>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-info">保存</button>
                </div>
              </div>
            </form>
          </div>
          <div role="tabpanel" class="tab-pane fade" id="modifyPwd" aria-labelledby="modifyPwd-tab">
            <div class="alert alert-warning" role="alert"><strong>请先输入旧密码</strong></div>
            <form class="form-horizontal">
              <div class="form-group">
                <label for="oldPassword" class="col-sm-2 control-label">旧密码：</label>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="oldPassword" placeholder="旧密码">
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
                  <button type="submit" class="btn btn-info">更改</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
