<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <title>微信管理后台 - 主页</title>
  <meta name="keywords" content="微信管理后台">
  <meta name="description" content="基于电商平台">
  <!--[if lt IE 9]>
  <meta http-equiv="refresh" content="0;ie.html" />
  <![endif]-->
  <link rel="shortcut icon" href="favicon.ico">
  <link href="${ctxStatic}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
  <link href="${ctxStatic}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
  <link href="${ctxStatic}/css/animate.min.css" rel="stylesheet">
  <link href="${ctxStatic}/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
  <!--左侧导航开始-->
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i>
    </div>
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element">
            <span><img alt="image" class="img-circle" src="${ctxStatic}/img/profile_small.jpg" /></span>
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
              <span class="clear">
                  <span class="block m-t-xs"><strong class="font-bold">Cheng</strong></span>
                  <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
              </span>
            </a>
            <ul class="dropdown-menu animated fadeInRight m-t-xs">
              <li><a class="J_menuItem" href="form_avatar.html">修改头像</a></li>
              <li><a class="J_menuItem" href="profile.html">个人资料</a></li>
              <li class="divider"></li>
              <li><a href="logout">安全退出</a></li>
            </ul>
          </div>
          <div class="logo-element">Shop</div>
        </li>
        <li>
          <a class="J_menuItem" href="home.html">
            <i class="fa fa-home"></i>
            <span class="nav-label">主页</span>
          </a>
        </li>
      </ul>
    </div>
  </nav>
  <!--左侧导航结束-->

  <!--右侧部分开始-->
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
          <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i></a>
          <form role="search" class="navbar-form-custom" method="post" action="http://www.zi-han.net/theme/hplus/search_results.html">
            <div class="form-group">
              <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
            </div>
          </form>
        </div>
        <ul class="nav navbar-top-links navbar-right">
          <li class="dropdown">
            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
              <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
            </a>
            <ul class="dropdown-menu dropdown-messages">
              <li class="m-t-xs">
                <div class="dropdown-messages-box">
                  <a href="profile.html" class="pull-left"><img alt="image" class="img-circle" src="${ctxStatic}/img/a7.jpg"></a>
                  <div class="media-body">
                    <small class="pull-right">46小时前</small>
                    <strong>小四</strong> 这个在日本投降书上签字的军官，建国后一定是个不小的干部吧？<br>
                    <small class="text-muted">3天前 2014.11.8</small>
                  </div>
                </div>
              </li>
              <li class="divider"></li>
              <li>
                <div class="dropdown-messages-box">
                  <a href="profile.html" class="pull-left"><img alt="image" class="img-circle" src="${ctxStatic}/img/a4.jpg"></a>
                  <div class="media-body ">
                    <small class="pull-right text-navy">25小时前</small>
                    <strong>国民岳父</strong> 如何看待“男子不满自己爱犬被称为狗，刺伤路人”？——这人比犬还凶<br>
                    <small class="text-muted">昨天</small>
                  </div>
                </div>
              </li>
              <li class="divider"></li>
              <li>
                <div class="text-center link-block">
                  <a class="J_menuItem" href="mailbox.html">
                    <i class="fa fa-envelope"></i><strong> 查看所有消息</strong>
                  </a>
                </div>
              </li>
            </ul>
          </li>
          <li class="dropdown">
            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
              <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
              <li>
                <a href="mailbox.html">
                  <div>
                    <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                    <span class="pull-right text-muted small">4分钟前</span>
                  </div>
                </a>
              </li>
              <li class="divider"></li>
              <li>
                <a href="profile.html">
                  <div>
                    <i class="fa fa-qq fa-fw"></i> 3条新回复
                    <span class="pull-right text-muted small">12分钟钱</span>
                  </div>
                </a>
              </li>
              <li class="divider"></li>
              <li>
                <div class="text-center link-block">
                  <a class="J_menuItem" href="notifications.html">
                    <strong>查看所有 </strong><i class="fa fa-angle-right"></i>
                  </a>
                </div>
              </li>
            </ul>
          </li>
          <li class="dropdown hidden-xs">
            <a class="right-sidebar-toggle" aria-expanded="false"><i class="fa fa-tasks"></i> 主题</a>
          </li>
        </ul>
      </nav>
    </div>
    <div class="row content-tabs">
      <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
      </button>
      <nav class="page-tabs J_menuTabs">
        <div class="page-tabs-content">
          <a href="javascript:;" class="active J_menuTab" data-id="home.html">首页</a>
        </div>
      </nav>
      <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
      </button>
      <div class="btn-group roll-nav roll-right">
        <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span></button>
        <ul role="menu" class="dropdown-menu dropdown-menu-right">
          <li class="J_tabShowActive"><a>定位当前选项卡</a></li>
          <li class="divider"></li>
          <li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
          <li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
        </ul>
      </div>
      <a href="logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
    </div>
    <div class="row J_mainContent" id="content-main">
      <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="home.html?v=4.0" frameborder="0" data-id="home.html" seamless></iframe>
    </div>
    <div class="footer">
      <div class="pull-right">By Cheng &copy; 2015-2016</div>
    </div>
  </div>
  <!--右侧部分结束-->

  <!--右侧边栏开始-->
  <div id="right-sidebar">
    <div class="sidebar-container">
      <ul class="nav nav-tabs navs-2">
        <li class="active"><a data-toggle="tab" href="#tab-1"><i class="fa fa-gear"></i> 主题</a></li>
        <li class=""><a data-toggle="tab" href="#tab-2">通知</a></li>
      </ul>
      <div class="tab-content">
        <div id="tab-1" class="tab-pane active">
          <div class="sidebar-title">
            <h3><i class="fa fa-comments-o"></i> 主题设置</h3>
            <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
          </div>
          <div class="skin-setttings">
            <div class="title">主题设置</div>
            <div class="setings-item">
              <span>收起左侧菜单</span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                  <label class="onoffswitch-label" for="collapsemenu">
                    <span class="onoffswitch-inner"></span>
                    <span class="onoffswitch-switch"></span>
                  </label>
                </div>
              </div>
            </div>
            <div class="setings-item">
              <span>固定顶部</span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                  <label class="onoffswitch-label" for="fixednavbar">
                    <span class="onoffswitch-inner"></span><span class="onoffswitch-switch"></span>
                  </label>
                </div>
              </div>
            </div>
            <div class="setings-item">
              <span>固定宽度</span>
              <div class="switch">
                <div class="onoffswitch">
                  <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                  <label class="onoffswitch-label" for="boxedlayout">
                    <span class="onoffswitch-inner"></span><span class="onoffswitch-switch"></span>
                  </label>
                </div>
              </div>
            </div>
            <div class="title">皮肤选择</div>
            <div class="setings-item default-skin nb">
              <span class="skin-name "><a href="#" class="s-skin-0">默认皮肤</a></span>
            </div>
            <div class="setings-item blue-skin nb">
              <span class="skin-name "><a href="#" class="s-skin-1">蓝色主题</a></span>
            </div>
            <div class="setings-item yellow-skin nb">
              <span class="skin-name "><a href="#" class="s-skin-3">黄色/紫色主题</a></span>
            </div>
          </div>
        </div>
        <div id="tab-2" class="tab-pane">
          <div class="sidebar-title">
            <h3> <i class="fa fa-comments-o"></i> 最新通知</h3>
            <small><i class="fa fa-tim"></i> 您当前有2条未读信息</small>
          </div>
          <div>
            <div class="sidebar-message">
              <a href="#">
                <div class="pull-left text-center">
                  <img alt="image" class="img-circle message-avatar" src="${ctxStatic}/img/a1.jpg">
                  <div class="m-t-xs">
                    <i class="fa fa-star text-warning"></i>
                    <i class="fa fa-star text-warning"></i>
                  </div>
                </div>
                <div class="media-body">
                  据天津日报报道：瑞海公司董事长于学伟，副董事长董社轩等10人在13日上午已被控制。<br>
                  <small class="text-muted">今天 4:21</small>
                </div>
              </a>
            </div>
            <div class="sidebar-message">
              <a href="#">
                <div class="pull-left text-center">
                  <img alt="image" class="img-circle message-avatar" src="${ctxStatic}/img/a2.jpg">
                </div>
                <div class="media-body">
                  HCY48之音乐大魔王会员专属皮肤已上线，快来一键换装拥有他，宣告你对华晨宇的爱吧！<br>
                  <small class="text-muted">昨天 2:45</small>
                </div>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--右侧边栏结束-->
</div>
<script src="${ctxStatic}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctxStatic}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${ctxStatic}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctxStatic}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctxStatic}/js/plugins/layer/layer.min.js"></script>
<script src="${ctxStatic}/js/hplus.min.js?v=4.1.0"></script>
<script src="${ctxStatic}/js/contabs.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/js/plugins/pace/pace.min.js"></script>
</body>
</html>
