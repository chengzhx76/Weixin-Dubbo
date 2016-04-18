<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="验证码输入框的名称"%>
<%@ attribute name="inputCssStyle" type="java.lang.String" required="false" description="验证码输入框样式"%>
<%@ attribute name="imgCssStyle" type="java.lang.String" required="false" description="图片样式"%>
<%@ attribute name="btnCssStyle" type="java.lang.String" required="false" description="看不清按钮样式"%>

<div class="form-group form-inline">
  <label for="captcha">验证码：</label>
  <input type="text" class="form-control" id="captcha" name="${name}" maxlength="4" placeholder="captcha" required style="font-weight:bold; width:100px; ${inputCssStyle}">
  <img src="${pageContext.request.contextPath}/drawCheckCode" class="${name}" onclick="$('.${name}Refresh').click()" style="margin-left:6px; cursor:pointer; ${imgCssStyle}">
  <a href="javascript:" class="${name}Refresh" onclick="$('.${name}').attr('src','${pageContext.request.contextPath}/drawCheckCode?'+new Date().getTime());" style="margin-left: 6px; ${btnCssStyle}">看不清</a>
</div>