package com.moov.web;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moov.bean.Content;

/**
 * springmvc中的验证
 * ContentController
 * 创建人:Sam
 * 时间：2017年3月18日-下午11:01:55 
 * @version 1.0.0
 *
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@ModelAttribute("content")
	public Content getContent(){
		return new Content();
	}
	
	@RequestMapping("/add")
	public String add(){
		System.out.println("run to s' add.....");
		return "content/add";
	}
	
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("content")Content content,BindingResult bindingResult){
		System.out.println("保存进来了.....");
		return "content/add";
	}
	
}
