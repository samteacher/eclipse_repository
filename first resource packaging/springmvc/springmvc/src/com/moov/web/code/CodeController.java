package com.moov.web.code;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 验证吗 CodeController<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2015年2月5日-下午11:37:16 <BR>
 * 
 * @version 1.0.0
 * 
 */
@Controller
public class CodeController {
	


	@ResponseBody
	@RequestMapping("/code")
	public byte[] code(HttpSession session) throws IOException {
		TzCodeUtil codeUtil = new TzCodeUtil();
		String code = codeUtil.createCode();
		System.out.println(code);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
		ImageIO.write(codeUtil.getBuffImg(), "JPEG", imageOut);
		imageOut.close();
		session.setAttribute("code", code);
		return output.toByteArray();
	}
	
	
}
