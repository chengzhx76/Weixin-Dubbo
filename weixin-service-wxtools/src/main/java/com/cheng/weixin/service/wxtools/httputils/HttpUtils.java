package com.cheng.weixin.service.wxtools.httputils;

/**
 * HTTP请求方法
 * @author Cheng
 */
public class HttpUtils {
//	/**
//	 * GET 请求
//	 * @param url 传入的微信地址
//	 * @return 微信返回的消息
//	 */
//	public static String httpGet(String url) {
//		CloseableHttpClient httpClient = null;
//		CloseableHttpResponse response = null;
//		try {
//			httpClient = HttpClientBuilder.create().build();
//			HttpGet httpget = new HttpGet(url);
//			response = httpClient.execute(httpget);
//			int statusCode = response.getStatusLine().getStatusCode();
//			if(statusCode>=200&&statusCode<300) {
//				HttpEntity entity = response.getEntity();
//				String content = EntityUtils.toString(entity,"UTF-8");
//				httpget.releaseConnection();
//				ErrorEntity err = JSON.parseObject(content, ErrorEntity.class);
//				if(err.getErrcode()!=null && !err.getErrcode().equals("0") &&
//				   err.getErrmsg()!=null && !err.getErrmsg().equals("ok")) {
//					throw new WeixinException(Integer.parseInt(err.getErrcode()), err.getErrmsg());
//				}
//				return content;
//			}
//		} catch (ParseException | IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(httpClient!=null) httpClient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if(response!=null) response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * POST 请求
//	 * @param url 传入的微信地址
//	 * @param data 需要发送的JSON参数
//	 * @return 微信回复的消息
//	 */
//	public static String httpPost(String url, String data) {
//		CloseableHttpClient httpClient = null;
//		CloseableHttpResponse response = null;
//		try {
//			httpClient = HttpClientBuilder.create().build();
//			HttpPost httppost = new HttpPost(url);
//			httppost.setHeader("Content-Type", "application/json");
//			StringEntity params = new StringEntity(data,"UTF-8");
//			httppost.setEntity(params);
//			response = httpClient.execute(httppost);
//			int statusCode = response.getStatusLine().getStatusCode();
//			if(statusCode>=HttpStatus.SC_OK&&statusCode<HttpStatus.SC_MULTIPLE_CHOICES) {
//				HttpEntity entity = response.getEntity();
//				String content = EntityUtils.toString(entity,"UTF-8");
//				httppost.releaseConnection();
//				ErrorEntity err = JSON.parseObject(content, ErrorEntity.class);
//				if(err.getErrcode()!=null && !err.getErrcode().equals("0") &&
//				   err.getErrmsg()!=null && !err.getErrmsg().equals("ok")) {
//					throw new WeixinException(Integer.parseInt(err.getErrcode()), err.getErrmsg());
//				}
//				return content;
//			}
//		} catch (UnsupportedCharsetException | IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(httpClient!=null) httpClient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if(response!=null) response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//	/**
//	 * 发送媒体消息
//	 * @param url 传入的微信地址
//	 * @param path 需要传入的媒体文件
//	 * @return 返回的结果
//	 */
//	public static String postMedia(String url, String path) {
//		CloseableHttpClient httpClient = null;
//		CloseableHttpResponse response = null;
//		try {
//			httpClient = HttpClientBuilder.create().build();
//			HttpPost httppost = new HttpPost(url);
//			FileBody fb = new FileBody(new File(path));
//			HttpEntity entity = MultipartEntityBuilder.create().addPart("media", fb).build();
//			httppost.setEntity(entity);
//			response = httpClient.execute(httppost);
//			int statusCode = response.getStatusLine().getStatusCode();
//			if(statusCode>=HttpStatus.SC_OK&&statusCode<HttpStatus.SC_MULTIPLE_CHOICES) {
//				HttpEntity entityContent = response.getEntity();
//				String content = EntityUtils.toString(entityContent,"UTF-8");
//				httppost.releaseConnection();
//				ErrorEntity err = JSON.parseObject(content, ErrorEntity.class);
//				if(err.getErrcode()!=null && !err.getErrcode().equals("0") &&
//				   err.getErrmsg()!=null && !err.getErrmsg().equals("ok")) {
//					throw new WeixinException(Integer.parseInt(err.getErrcode()), err.getErrmsg());
//				}
//				return content;
//			}
//		} catch (ParseException | IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(httpClient!=null) httpClient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if(response!=null) response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//	/**
//	 * 根据媒体ID下载媒体资源
//	 * @param url
//	 * @param path
//	 */
//	public static void getMidie(String url, String path) {
//		CloseableHttpClient httpClient = null;
//		CloseableHttpResponse response = null;
//		InputStream is = null;
//		try {
//			httpClient = HttpClientBuilder.create().build();
//			HttpGet httpget = new HttpGet(url);
//			response = httpClient.execute(httpget);
//			int statusCode = response.getStatusLine().getStatusCode();
//			if(statusCode>=HttpStatus.SC_OK&&statusCode<HttpStatus.SC_MULTIPLE_CHOICES) {
//				HttpEntity entity = response.getEntity();
//				if(!entity.getContentType().getValue().equals("text/plain")) {
//					is = entity.getContent();
//					FileUtils.copyInputStreamToFile(is, new File(path));
//					httpget.releaseConnection();
//				}else {
//					String content = EntityUtils.toString(entity,"UTF-8");
//					httpget.releaseConnection();
//					ErrorEntity err = JSON.parseObject(content, ErrorEntity.class);
//					if(err.getErrcode()!=null && !err.getErrcode().equals("0") &&
//							err.getErrmsg()!=null && !err.getErrmsg().equals("ok")) {
//						throw new WeixinException(Integer.parseInt(err.getErrcode()), err.getErrmsg());
//					}
//				}
//			}
//		} catch (ParseException | IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(httpClient!=null) httpClient.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if(response!=null) response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if(is!=null) is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
