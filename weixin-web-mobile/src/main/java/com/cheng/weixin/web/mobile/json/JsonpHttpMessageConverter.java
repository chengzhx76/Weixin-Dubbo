package com.cheng.weixin.web.mobile.json;

import com.cheng.weixin.common.utils.StringUtils;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Desc:支持 JSONP
 * Author: Cheng
 * Date: 2016/3/10 0010
 */

/**
  $.ajax({
     type: <your type>,
     url: <your url>,
     dataType: 'jsonp',
     jsonpCallback: 'JsonpCallback', //这个值要与第一步的ConfigContainer.JSONP_CALLBACK同名
     contentType: 'application/jsonp;charset=UTF-8',
     }).done(function (result) {
     //TODO
     }).fail(function (result, textStatus, info) {
     //TODO
     });
  }
 */
public class JsonpHttpMessageConverter extends MappingJackson2HttpMessageConverter {
    private String callbackName;
    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String callbackParam = request.getParameter(callbackName);
        if(StringUtils.isEmpty(callbackParam)) {
            super.writeInternal(object, type, outputMessage);
        }else {
            JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
            try {
                //String result = callbackParam + "(" + super.getObjectMapper().writeValueAsString(object) +")";
                String result = getObjectMapper().writeValueAsString(new JSONPObject(callbackParam, object));
                IOUtils.write(result, outputMessage.getBody(), encoding.getJavaName());
            } catch (IOException e) {
                e.printStackTrace();
                throw new HttpMessageNotWritableException("Could not write JSON:" + e.getMessage(), e);
            }
        }
    }

    public void setCallbackName(String callbackName) {
        this.callbackName = callbackName;
    }


}
