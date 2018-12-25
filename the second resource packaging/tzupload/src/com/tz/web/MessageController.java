/**
 * Project Name:tzupload
 * File Name:TzUploadController.java
 * Package Name:tzupload
 * Date:2015��11��5������9:09:13
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.tz.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.User;

/**
 * ClassName:TzUploadController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015��11��5�� ����9:09:13 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.6
 * @see
 */
@Controller
@RequestMapping("/message")
public class MessageController  extends BaseController{
	
	/*
	 * 
	 * 	HttpMessageConvert��,������������Ϣת����һ�����󣬽����л��õĶ���ͨ����Ӧ�������.
	 *  ԭ��reponse.getWrite(�����ķ���ֵ);
	 *  
	 *  boolean canWrite(Class<?> clazz, MediaType mediaType);
	 *  MIME���ͣ�content-type="text/json;charset=utf-9"
	 *  
	 *  //��ȡ
	 *  List<MediaType> getSupportedMediaTypes();��ȡת������֧�ֵ� mideaType���� 
	 *  
	 *  T read(Class<? extends T> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException;
	 *  
	 * */
	
	
	@ResponseBody
	@RequestMapping(value={"/handle","/main"})
	public String handle(){
		return "<span>ˮ���ˮ���</span>";
	}
	
	
	@ResponseBody
	@RequestMapping("/handle2")
	public User handle2(){
		User user = new User();
		user.setUsername("ˮ����ٶ�");
		user.setPhone("15074816437");
		user.setTime(new Date());
		user.setAge(30);
		return user;
	}
	
	@RequestMapping("/handle3")
	public void handle3() throws IOException, JSONException{
		response.setContentType("application/json;charset=utf-8");
		User user = new User();
		user.setUsername("ˮ����ٶ�");
		user.setPhone("15074816437");
		user.setTime(new Date());
		user.setAge(30);
		PrintWriter writer = response.getWriter();
		writer.print(JSONUtil.serialize(user));
		writer.flush();
		writer.close();
	}
	
	@ResponseBody
	@RequestMapping("/handle4")
	public void handle4(){
		User user = new User();
		user.setUsername("ˮ����ٶ�");
		user.setPhone("15074816437");
		user.setTime(new Date());
		user.setAge(30);
		jsonToString(user);
	}
	
	
	
	public static void main(String[] args) throws JSONException {
//		User user = new User();
//		user.setUsername("ˮ����ٶ�");
//		user.setPhone("15074816437");
//		user.setAge(30);
//		List<Pattern> patterns = new ArrayList<>();
//		patterns.add(Pattern.compile("age|username|phone"));
//		List<Pattern> cpatterns = new ArrayList<>();
//		cpatterns.add(Pattern.compile("email"));
//		//struts2 --- ajax json-lib.jar
//		System.out.println(JSONUtil.serialize(user, patterns, cpatterns, false, true, true));
	}
	
}
