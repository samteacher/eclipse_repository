package com.moov.web.upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.moov.web.ITmContextProvider;
/**
 * 文件上传
 * 
 * UploadController
 * 创建人:Sam
 * 时间：2017年3月9日-下午7:43:15 
 * @version 1.0.0
 *
 */
@Controller
public class UploadController {
	
	@Autowired
	private ITmContextProvider contextProvider;

	@RequestMapping("/uploadPage")
	public String uploadPage(){
		
		return "upload";
	}
	
	/**
	 * 文件上传类
	 * com.moov.web.upload 
	 * 方法名：upload
	 * 创建人：Sam
	 * 时间：2017年3月9日-下午7:52:29 
	 * @param file
	 * @param request
	 * @throws IllegalStateException
	 * @throws IOException void
	 * @exception 
	 * @since  1.0.0
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public void upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		String path = contextProvider.getApplicationRealPath("upload")+"/"+UUID.randomUUID().toString()+".jpg";
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());
		file.transferTo(new File(path));
	}
	
}
