package com.cheng.weixin.web.manage;

import com.cheng.weixin.commom.utils.StringUtils;
import com.cheng.weixin.rpc.wxtools.content.WeixinContent;
import com.cheng.weixin.rpc.wxtools.service.RpcMessageHandleService;
import com.cheng.weixin.rpc.wxtools.constant.WeixinFinalValue;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Controller
public class WeixinController {
	private static final Logger log = LoggerFactory.getLogger(WeixinController.class);

	@Resource
	private WeixinFinalValue weixinFinalValue;
	@Resource
	private RpcMessageHandleService messageHandle;

	@RequestMapping(value="getWxMsg",method=RequestMethod.GET)
	public void initWx(String signature, String timestamp, String nonce, String echostr, HttpServletResponse response) throws IOException {
		if(StringUtils.isNoneBlank(signature, timestamp, nonce, echostr)) {
			String[] arrs = {weixinFinalValue.WX_TOKEN, timestamp, nonce};
			Arrays.sort(arrs);
			StringBuffer sb = new StringBuffer();
			for(String wx:arrs) {
				sb.append(wx);
			}
			String sha1 = DigestUtils.sha1Hex(sb.toString());
			if(signature.equals(sha1)) {
				response.getWriter().write(echostr);
			}
		}else {
			log.error("参数为空，或缺少参数！");
		}
	}
	
	@RequestMapping(value="getWxMsg",method=RequestMethod.POST)
	public void getWxMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/xml;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		Map<String, String> msgMap = messageHandle.reqMsg2Map(request);
		String respMsg = messageHandle.handleResp(msgMap);
		
		log.debug("\n回复的XML为：\n{}", respMsg);
		
		response.getWriter().write(respMsg);
		
//		if(null!=respMsg) {
//			response.getWriter().write(respMsg);
//		}else {
//			response.getWriter().write("success");
//		}
	}
	
	@RequestMapping(value="getat",method=RequestMethod.GET)
	public void getAccessToken(HttpServletResponse response) throws IOException {
		response.getWriter().write(WeixinContent.getInstance().getAccessToken());
	}
	
	@RequestMapping("index")
	public String index() {
	    return "index";
	}
}
