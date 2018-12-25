package com.sam.aop.cjlib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * CGLIB测试类
 * @author Administrator
 *
 */
public class TestCgibl {

	public static void main(String[] args) {
		
		//目标类
		BookFacadeImpl bookFacadeImpl = new BookFacadeImpl();
		//代理类
		BookFacadeCglib cglib = new BookFacadeCglib();
		//创建一个Java代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BookFacadeImpl.class);
        enhancer.setCallback(new BookFacadeCglib());
        BookFacadeImpl target = (BookFacadeImpl) enhancer.create();
        target.addBook();
        System.out.println("proxy class name:" + target.getClass().getName());
        
        
	}
}
