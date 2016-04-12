package com.cheng.weixin.service.wxtools.utils;

import com.cheng.weixin.rpc.wxtools.enums.MsgType;
import com.cheng.weixin.rpc.wxtools.enums.Event;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import java.io.Serializable;
import java.io.Writer;

/**
 * XML工具类
 * @author Cheng
 *
 */
public class XMLUtils {
	/**
	 * 将文本消息转换成XML
	 * @param msg
	 * @return
	 */
	public static String msg2XML(Serializable msg) {
		xstream.alias("xml", msg.getClass());
		return xstream.toXML(msg);
	}
	
//	public static String voiceMsg2XML(VoiceMessage voiceMsg) {
//		xstream.alias("xml", voiceMsg.getClass());
//		return xstream.toXML(voiceMsg);
//	}
	
	// 扩展xstream，使其支持CDATA块
	private static XStream xstream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				
				boolean cdata;
				
				@SuppressWarnings("rawtypes")
				@Override
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
					cdata = false;
					if(clazz.equals(String.class)||clazz.equals(Event.class)||clazz.equals(MsgType.class)) {
						cdata=true;
					}
					
				}

				@Override
				protected void writeText(QuickWriter writer, String text) {
					if(cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else {
						writer.write(text);
					}
				};
				
			};
		}
	});
	
	
	
}
