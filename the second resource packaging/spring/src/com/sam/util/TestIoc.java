package com.sam.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.sam.ioc.XiaoQiao;

public class TestIoc {

	public static void main(String[] args) {
		

//		Resource resource = new ClassPathResource("bean.xml");
//		BeanFactory beanFactory = new XmlBeanFactory(resource);
//		XiaoQiao xiaoQiao = (XiaoQiao) beanFactory.getBean("xiaoqiao");
//		xiaoQiao.sayHello();

		
		Resource resource = new FileSystemResource("E:/myeclipseworkspace/spring/src/bean.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		XiaoQiao xiaoQiao = (XiaoQiao) beanFactory.getBean("xiaoqiao");
		xiaoQiao.sayHello();
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		XiaoQiao xiaoQiao2 = (XiaoQiao) context.getBean("xiaoqiao");
		xiaoQiao2.sayHello();
	}
}
