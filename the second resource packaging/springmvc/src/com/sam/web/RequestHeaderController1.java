package com.sam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取Servlet请求头
 * @author Administrator
 *
 */
@Controller
public class RequestHeaderController1 {

	@RequestMapping("/header2")
    public String getHeader(
            @RequestHeader("Host") String host,
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader("Accept") String accept,
            @RequestHeader("Accept-Language") String acceptLanguage,
            @RequestHeader("Accept-Encoding") String acceptEncoding,
            @RequestHeader("Cookie") String cookie,
            @RequestHeader("Connection") String conn,
            @CookieValue("JSESSIONID") String cookie2){
        //@RequestHeader将http请求头信息赋值给形参
        //@CookieValue直接将请求头中的cookie的值赋值给形参
        System.out.println("host:" + host);
        System.out.println("userAgent:" + userAgent);
        System.out.println("accept:" + accept);
        System.out.println("acceptLanguage:" + acceptLanguage);
        System.out.println("acceptEncoding:" + acceptEncoding);
        System.out.println("cookie:" + cookie);
        System.out.println("conn:" + conn);
        System.out.println("cookie2:" + cookie2);
        return "index"; 
    }
}
