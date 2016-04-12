package com.cheng.weixin.web.manage;

import com.cheng.weixin.rpc.wxtools.exception.MassageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandle {
	private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandle.class);
	
	/**
	 * 处理消息异常
	 * @param response
	 * @param exception
	 * @throws IOException 
	 */
	@ExceptionHandler(MassageException.class)
	public void handleMassageException(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException {
		MassageException msgException = (MassageException) exception;
		log.error("请求处理异常，错误代码：{}，错误消息：{}",msgException.getCode(), msgException.getErrorMsg());
		
		response.getWriter().write("success");
		
		/* 这块代码有问题
		Map<String, String> msgMap = new HashMap<>();
		String content = "请求处理异常，请稍后再试！";
		try {
			String msg = IOUtils.toString(request.getInputStream(),"UTF-8");
			log.debug("\n接收到的XML为（还未处理）：\n{}", msg);
			Document document = DocumentHelper.parseText(msg);
			Element root = document.getRootElement();
			List<Element> elements = root.elements();
			for(Element element:elements) {
				msgMap.put(element.getName(), element.getText());
			}
			TextMessage textMsg = new TextMessage();
			textMsg.setToUserName(msgMap.get("FromUserName"));
			textMsg.setFromUserName(msgMap.get("ToUserName"));
			textMsg.setCreateTime(new Date().getTime());
			textMsg.setMsgType(MsgType.text);
			textMsg.setContent(content);
			response.getWriter().write(XMLUtils.msg2XML(textMsg));
		} catch (IOException | DocumentException e) {
			response.getWriter().write("success");
			log.error("异常处理时发生错误，错误消息：{}", e.getMessage());
		}*/
		
	}
}
