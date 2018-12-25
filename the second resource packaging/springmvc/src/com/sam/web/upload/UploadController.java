package com.sam.web.upload;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sam.util.ITmContextProvider;


/**
 * 
 * 文件上传
 * UploadController<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2015年2月6日-上午12:06:30 <BR>
 * @version 1.0.0
 *
 */
@Controller
public class UploadController implements ServletContextAware,BeanNameAware{

	@Autowired
	private ITmContextProvider contextProvider;
	
	private ServletContext application;
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	};
	
	@Override
	public void setBeanName(String beanName) {
		System.out.println("当前类在beanFactory的key是========="+beanName);
	}
	
	@RequestMapping("/uploadPage")
	public String uploadPage(){
		return "upload";
	}
	
	/**
	 * 
	 * 
	 * 文件上传类
	 * 方法名：upload<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2015年2月6日-上午12:11:11 <BR>
	 * @param file
	 * @param request
	 * @throws IllegalStateException
	 * @throws IOException void<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 * 
	 * 
	 * 文件上的步骤：
	 * 1upload.jsp:<form enctype="mulitpart/form-data">
	 * 2:定义文件上传的类UploadController  @RequestParam("file")MultipartFile file
	 * @RequestParam("file")MultipartFile 
	 * <input type="file" name="file">
	 * org.springframework.web.multipart.MultipartException: The current request is not a multipart request
	 */
	
	@RequestMapping(value="/upload")
	public String tzupload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		String realPath = contextProvider.getApplicationRealPath("tzupload");
//		String realPath = application.getRealPath("tzupload");
		File dirPath = new File(realPath);
		//自动创建上传的upload目录
		if(!dirPath.exists())dirPath.mkdirs();
		String oldName = file.getOriginalFilename();
		System.out.println(oldName);
		System.out.println(file.getSize());
		System.out.println(TmFileUtil.countFileSize(file.getSize()));
		System.out.println(TmFileUtil.getExt(oldName));
		System.out.println(TmFileUtil.getExtNoPoint(oldName));
		System.out.println(file.getName());
		System.out.println(file.getContentType());
//		String path =realPath+"/"+UUID.randomUUID().toString()+TmFileUtil.getExt(oldName);
		String newName = TmFileUtil.generateFileName(oldName, 5, "yyyyMMddHHmmss");
		File targetFile = new File(dirPath, newName);
		file.transferTo(targetFile);//文件上传
		return "redirect:index.jsp";
	}
}
