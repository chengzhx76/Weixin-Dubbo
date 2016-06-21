package com.cheng.weixin.common.utils;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Desc: 封装的各种编码/解码工具类
 * 1.Commons-Codec的 hex/base64 编码
 * 2.Commons-Lang的xml/html escape
 * Author: Cheng
 * Date: 2016/1/29 0029
 */
public class Encodes {
    /**
     * Hex编码
     * @param input
     * @return
     */
    public static String encodeHex(byte[] input) {
        return new String(Hex.encodeHex(input));
    }

    /**
     * Hex解码
     * @param input
     * @return
     */
    public static byte[] decodeHex(String input) {
        try {
            return Hex.decodeHex(input.toCharArray());
        } catch (DecoderException e) {
            throw Exceptions.unchecked(e);
        }
    }

    /**
     * Html 解码
     * @param htmlEscaped
     * @return
     */
    public static String unescapeHtml(String htmlEscaped) {
        return StringEscapeUtils.unescapeHtml4(htmlEscaped);
    }

}
