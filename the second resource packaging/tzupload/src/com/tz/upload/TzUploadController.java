/**
 * Project Name:tzupload
 * File Name:TzUploadController.java
 * Package Name:tzupload
 * Date:2015��11��5������9:09:13
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.tz.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tz.util.ImageUtil;
import com.tz.web.BaseController;

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
@RequestMapping("/up")
public class TzUploadController extends BaseController {
	
	@RequestMapping("/index")
	public String index(){
		return "upload/upload";
	}
	
	
	@ResponseBody /*�ϴ��ɹ��Ժ���response.getWriter()�����������*/
	@RequestMapping(value = "/file")
	public String tzupload(@RequestParam("doc") MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException, JSONException {
		if(!file.isEmpty()){
			String path = request.getRealPath("/upload");
			File parent = new File(path);
			if(!parent.exists())parent.mkdirs();
//			System.out.println("��ȡ�ļ�����================="+file.getBytes());
//			System.out.println("��ȡ�ļ���MINE����================="+file.getContentType());
//			System.out.println("��ȡ�ļ�������================="+file.getName());
//			System.out.println("��ȡ�ϴ��ļ���ԭ��================="+file.getOriginalFilename());
//			System.out.println("��ȡ�ļ��Ĵ�С================="+file.getSize());
//			System.out.println("�ж��Ƿ����ļ��ϴ�================="+file.isEmpty());
			HashMap<String, Object> map = new HashMap<String,Object>();
			String oldName = file.getOriginalFilename();
			long size = file.getSize();
			String sizeString = TmFileUtil.countFileSize(size);
			String ext = TmFileUtil.getExtNoPoint(oldName);
			String newFileName = TmFileUtil.generateFileName(oldName, 10, "yyyyMMddHHmmss");
			String url = "upload/"+newFileName;
			file.transferTo(new File(parent, newFileName));
			map.put("oldname",oldName);
			map.put("ext",ext);
			map.put("sizeString",sizeString);
			map.put("size",size);
			map.put("name",newFileName);
			map.put("url",url);
			return JSONUtil.serialize(map);
		}else{
			return null;
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="/cut",method=RequestMethod.POST)
	public HashMap<String, Object> cutImages(HttpServletRequest request) throws IOException{
		String bigSrc = request.getParameter("bgsrc");
		//ͷ��ü�������ͼƬ�Ǹ���
		String smallSrc = request.getParameter("smallsrc");
		String realpath = contextProvider.getApplicationRealPath(bigSrc);
		String targetPath = contextProvider.getApplicationRealPath(smallSrc);
		File file = new File(targetPath);
		//�õ��ļ����ڵ�Ŀ¼
		File pFile = file.getParentFile();
		//��������ڽ��д���
		if(!pFile.exists())pFile.mkdirs();
		
		Integer x = Integer.parseInt(request.getParameter("x"));
		Integer y = Integer.parseInt(request.getParameter("y"));
		Integer w = Integer.parseInt(request.getParameter("w"));
		Integer h = Integer.parseInt(request.getParameter("h"));
		ImageUtil.cutImage(realpath,targetPath,x,y,w,h);
		//ԭͼɾ��
		//new File(realpath).delete();
		return null;
	}
	
	
	public static void main(String[] args) {
		
	}
}
