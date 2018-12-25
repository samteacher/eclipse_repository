package com.moov.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeadController {

	/**
	 * 把请求里面的报文头全部获取出来
	 * 方法名：getHello<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2015年2月3日-下午11:46:16 <BR>
	 * @param hostName
	 * @param acceptType
	 * @param acceptLang
	 * @param acceptEnc
	 * @param cacheCon
	 * @param cookie
	 * @param userAgent
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	@RequestMapping("/header")
	public String  test(
		@RequestHeader ("host") String hostName,
		@RequestHeader ("Accept") String acceptType,
		@RequestHeader ("Accept-Language") String acceptLang,
		@RequestHeader ("Accept-Encoding") String acceptEnc,
		@RequestHeader ("Cache-Control") String cacheCon,
		@RequestHeader ("Cookie") String cookie,
		@RequestHeader ("User-Agent") String userAgent)
	{
	    	System.out.println("Host : " + hostName);
	    	System.out.println("Accept : " + acceptType);
	    	System.out.println("Accept Language : " + acceptLang);
	    	System.out.println("Accept Encoding : " + acceptEnc);
	    	System.out.println("Cache-Control : " + cacheCon);
	    	System.out.println("Cookie : " + cookie);
	    	System.out.println("User-Agent : " + userAgent);
	    	return "test";
    }
	
}
