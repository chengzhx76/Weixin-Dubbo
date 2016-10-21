<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="验证码输入框的名称"%>

<div class="captcha-area m-b">
  <input type="text" class="form-control captcha" name="${name}" maxlength="4" required placeholder="验证码"/>
  <img src="${pageContext.request.contextPath}/drawCheckCode" title="点击刷新" class="captchaCode" onclick="$('.captchaCode').attr('src','${pageContext.request.contextPath}/drawCheckCode?'+new Date().getTime());" style="cursor:pointer;">
</div>