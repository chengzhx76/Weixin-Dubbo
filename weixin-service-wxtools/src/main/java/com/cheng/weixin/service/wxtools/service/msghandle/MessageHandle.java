package com.cheng.weixin.service.wxtools.service.msghandle;

import com.cheng.weixin.rpc.wxtools.enums.Event;
import com.cheng.weixin.rpc.wxtools.enums.MsgType;
import com.cheng.weixin.rpc.wxtools.enums.Status;
import com.cheng.weixin.rpc.wxtools.request.model.ImageMessage;
import com.cheng.weixin.rpc.wxtools.request.model.TextMessage;
import com.cheng.weixin.rpc.wxtools.request.model.WxImage;
import com.cheng.weixin.rpc.wxtools.service.RpcMessageHandleService;
import com.cheng.weixin.common.exception.MassageException;
import com.cheng.weixin.service.wxtools.utils.XMLUtils;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息处理类
 * @author Cheng
 */
@Component("messageHandle")
public class MessageHandle implements RpcMessageHandleService {
	private static final Logger log = LoggerFactory.getLogger(MessageHandle.class);
	
	/**
	 * 把XML转换程Map对象
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> reqMsg2Map(HttpServletRequest request) {
		Map<String, String> maps = new HashMap<>();
		try {
			String msg = IOUtils.toString(request.getInputStream(),"UTF-8");
			
			log.debug("\n接收到的XML为：\n{}", msg);
			
			Document document = DocumentHelper.parseText(msg);
			Element root = document.getRootElement();
			List<Element> elements = root.elements();
			for(Element element:elements) {
				maps.put(element.getName(), element.getText());
			}
			return maps;
		} catch (IOException | DocumentException e) {
			log.error("消息转换Map出错！错误消息：{}", e.getMessage());
			throw new MassageException(3000, "消息转换Map出错");
		}
	}
	
	/**
	 * 返回的消息总入口
	 * @param msgMap
	 * @return
	 */
	@Override
	public String handleResp(Map<String, String> msgMap) {
		String msgType = msgMap.get("MsgType");
		String eventType = msgMap.get("Event");
		if(eventType!=null) {
			if(Event.unsubscribe.name().equals(eventType)) {
				return handleUnsubscribe(msgMap);
			}else if(MsgType.event.name().equals(msgType)) {
				return handleEvent(msgMap);
			}
		}else if(msgType!=null) {
			if(MsgType.text.name().equals(msgType)||MsgType.voice.name().equals(msgType)
					||MsgType.image.name().equals(msgType)||MsgType.shortvideo.name().equals(msgType)
					||MsgType.location.name().equals(msgType)||MsgType.link.name().equals(msgType)) {
				
				return handleMsg(msgMap);
			}
		}
		throw new MassageException(30001, "没有此消息类型和事件类型");
	}
	/**
	 * 用户取消订阅
	 * @param msgMap
	 * @return
	 */
	private String handleUnsubscribe(Map<String, String> msgMap) {
		log.info("用户取消关注！");
		return "success";
	}
	
	/**
	 * 消息处理
	 * @param msgMap
	 * @return
	 */
	private String handleMsg(Map<String, String> msgMap) {
		String msgType = msgMap.get("MsgType");
		if(MsgType.text.name().equals(msgType)) {
			return textTypeMsgHandle(msgMap, "你发送的是text消息！");
		}else if(MsgType.voice.name().equals(msgType)) {
			return textTypeMsgHandle(msgMap, "你发送的是voice消息！");
		}else if(MsgType.image.name().equals(msgType)) {
			return imageTypeMsgHandle(msgMap);
		}else if(MsgType.shortvideo.name().equals(msgType)) {
			return textTypeMsgHandle(msgMap, "你发送的是shortvideo消息！");
		}else if(MsgType.location.name().equals(msgType)) {
			return textTypeMsgHandle(msgMap, "你发送的是location消息！");
		}else if(MsgType.link.name().equals(msgType)) {
			return textTypeMsgHandle(msgMap, "你发送的是link消息！");
		}
		throw new MassageException(30002, "没有此消息类型");
	}
	/**
	 * 处理事件
	 * @param msgMap
	 * @return
	 */
	private String handleEvent(Map<String, String> msgMap) {
		String eventType = msgMap.get("Event");
		if(Event.subscribe.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "谢谢关注！");
		}else if(Event.CLICK.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "自定义菜单事件！");
		}else if(Event.LOCATION.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "上报地理位置事件！");
		}else if(Event.SCAN.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "扫描带参数二维码事件！");
		}else if(Event.VIEW.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "点击菜单跳转链接时的事件推送！");
		}else if(Event.click.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "点击推事件！");
		}else if(Event.view.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "跳转URL！");
		}else if(Event.scancode_push.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "扫码推事件！");
		}else if(Event.scancode_waitmsg.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "扫码带提示！");
		}else if(Event.pic_sysphoto.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "弹出系统拍照发图！");
		}else if(Event.pic_photo_or_album.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "弹出拍照或者相册发图！");
		}else if(Event.pic_weixin.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "弹出微信相册发图器！");
		}else if(Event.location_select.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "弹出地理位置选择器！");
		}else if(Event.media_id.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "下发消息（除文本消息）！");
		}else if(Event.view_limited.name().equals(eventType)) {
			return textTypeMsgHandle(msgMap, "跳转图文消息URL！");
		}else if(Event.TEMPLATESENDJOBFINISH.name().equals(eventType)) {
			// 主动发消息是不用给微信回复消息的，回复了用户也接不到
			String status = msgMap.get("Status"); 
			String msgID = msgMap.get("MsgID"); 
			if(Status.SUCCESS.getName().equals(status)) {
				log.debug("消息发送成功，消息ID：{}", msgID);
			}else if(Status.SYSTEM_FAILED.getName().equals(status)) {
				log.debug("消息发送失败，消息ID：{}", msgID);
			}else if(Status.USER_BLOCK.getName().equals(status)) {
				log.debug("消息被用户拒收，消息ID：{}", msgID);
			}else {
				log.debug("消息发送遇到未知异常，消息ID：{}", msgID);
			}
			return "success";
		}
		throw new MassageException(30003, "没有此事件类型");
	}
	
	/**
	 * 文本消息的处理
	 * @param msgMap
	 * @return
	 */
	private String textTypeMsgHandle(Map<String, String> msgMap, String content) {
		TextMessage textMsg = new TextMessage();
		textMsg.setToUserName(msgMap.get("FromUserName"));
		textMsg.setFromUserName(msgMap.get("ToUserName"));
		textMsg.setCreateTime(new Date().getTime());
		textMsg.setMsgType(MsgType.text);
		textMsg.setContent(content);
		
		return XMLUtils.msg2XML(textMsg);
	}
	/**
	 * 图片消息处理
	 * @param msgMap
	 * @return
	 */
	private String imageTypeMsgHandle(Map<String, String> msgMap) {
		ImageMessage imgMsg = new ImageMessage();
		imgMsg.setToUserName(msgMap.get("FromUserName"));
		imgMsg.setFromUserName(msgMap.get("ToUserName"));
		imgMsg.setCreateTime(new Date().getTime());
		imgMsg.setMsgType(MsgType.image);
		WxImage img = new WxImage();
		String mediaId = "M8K2WcayqjRaisQMCygVpWk1VDAjL8XMhvB66Y5TpBHsopHViOEOIR4semy9oOAD";
		img.setMediaId(mediaId);
		imgMsg.setImage(img);
		
		return XMLUtils.msg2XML(imgMsg);
	}
	
}
