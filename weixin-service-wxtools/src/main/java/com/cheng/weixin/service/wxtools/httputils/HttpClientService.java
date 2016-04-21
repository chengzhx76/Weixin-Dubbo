package com.cheng.weixin.service.wxtools.httputils;

import org.springframework.stereotype.Component;

/**
 * Desc: HttpClien 请求封装
 * Author: Cheng
 * Date: 2016/4/13 0013
 */
@Component
public class HttpClientService {

//    @Autowired
//    private CloseableHttpClient httpClient;
//    @Autowired
//    private RequestConfig requestConfig;
//
//    /**
//     * GET请求
//     * @param url
//     * @return
//     */
//    public String doGet(String url) {
//        CloseableHttpResponse response = null;
//        HttpGet httpGet = new HttpGet(url);
//        httpGet.setConfig(requestConfig);
//        try {
//            response = httpClient.execute(httpGet);
//            int statusCode = response.getStatusLine().getStatusCode();
//            if(statusCode>= HttpStatus.SC_OK&&statusCode<HttpStatus.SC_MULTIPLE_CHOICES) {
//                return getResponseContent(response, httpGet);
//            }
//            return null;
//        } catch (ParseException | IOException e) {
//            e.printStackTrace();
//        }finally {
//            closeResponse(response);
//        }
//        return null;
//    }
//
//    /**
//	 * POST 请求
//	 * @param url 传入的微信地址
//	 * @param data 需要发送的JSON参数
//	 * @return 微信回复的消息
//	 */
//	public String doPost(String url, String data) {
//        CloseableHttpResponse response = null;
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.setConfig(requestConfig);
//        try {
//            httpPost.setHeader("Content-Type", "application/json");
//            StringEntity params = new StringEntity(data,"UTF-8");
//            httpPost.setEntity(params);
//            response = httpClient.execute(httpPost);
//            int statusCode = response.getStatusLine().getStatusCode();
//            if(statusCode>= HttpStatus.SC_OK&&statusCode<HttpStatus.SC_MULTIPLE_CHOICES) {
//                return getResponseContent(response, httpPost);
//            }
//            return null;
//        } catch (UnsupportedCharsetException| IOException e) {
//            e.printStackTrace();
//        }finally {
//            closeResponse(response);
//        }
//        return null;
//    }
//	/**
//	 * 发送媒体消息
//	 * @param url 传入的微信地址
//	 * @param path 需要传入的媒体文件
//	 * @return 返回的结果
//	 */
//	public String postMedia(String url, String path) {
//		CloseableHttpResponse response = null;
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.setConfig(requestConfig);
//		try {
//			FileBody fb = new FileBody(new File(path));
//			HttpEntity entity = MultipartEntityBuilder.create().addPart("media", fb).build();
//            httpPost.setEntity(entity);
//			response = httpClient.execute(httpPost);
//			int statusCode = response.getStatusLine().getStatusCode();
//            if(statusCode>= HttpStatus.SC_OK&&statusCode<HttpStatus.SC_MULTIPLE_CHOICES) {
//                return getResponseContent(response, httpPost);
//            }
//            return null;
//		} catch (ParseException | IOException e) {
//			e.printStackTrace();
//		}finally {
//            closeResponse(response);
//		}
//		return null;
//	}
//	/**
//	 * 根据媒体ID下载媒体资源
//	 * @param url
//	 * @param path
//	 */
//	public void getMidie(String url, String path) {
//		CloseableHttpResponse response = null;
//		InputStream is = null;
//		try {
//			HttpGet httpGet = new HttpGet(url);
//			response = httpClient.execute(httpGet);
//			int statusCode = response.getStatusLine().getStatusCode();
//			if(statusCode>=HttpStatus.SC_OK&&statusCode<HttpStatus.SC_MULTIPLE_CHOICES) {
//				HttpEntity entity = response.getEntity();
//				if(!entity.getContentType().getValue().equals("text/plain")) {
//					is = entity.getContent();
//					FileUtils.copyInputStreamToFile(is, new File(path));
//                    httpGet.releaseConnection();
//				}else {
//                    getResponseContent(response, httpGet);
//				}
//			}
//		} catch (ParseException | IOException e) {
//			e.printStackTrace();
//		}finally {
//            closeResponse(response);
//            closeInputStream(is);
//        }
//	}
//
//    // 获取响应结果
//    private String getResponseContent(CloseableHttpResponse response, HttpRequestBase httpRequest) throws IOException {
//        HttpEntity entity = response.getEntity();
//        String content = EntityUtils.toString(entity,"UTF-8");
//        httpRequest.releaseConnection();
//        ErrorEntity err = JSON.parseObject(content, ErrorEntity.class);
//        if(err.getErrcode()!=null && !err.getErrcode().equals("0") &&
//                err.getErrmsg()!=null && !err.getErrmsg().equals("ok")) {
//            throw new WeixinException(Integer.parseInt(err.getErrcode()), err.getErrmsg());
//        }
//        return content;
//    }
//    // 关闭响应
//    private void closeResponse(CloseableHttpResponse response) {
//        try {
//            if(response!=null) response.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    // 关闭流
//    private void closeInputStream(InputStream is) {
//        try {
//            if(is!=null) is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
