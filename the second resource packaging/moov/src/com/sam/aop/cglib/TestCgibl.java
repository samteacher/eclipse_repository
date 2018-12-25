package com.sam.aop.cglib;

/**
 * CGLIB测试
 */
public class TestCgibl {

	public static void main(String[] args) {
		
		//目标类
		BookFacadeImpl bookimpl = new BookFacadeImpl();
		//代理类
		BookFacadeCglib cglib = new BookFacadeCglib();
		
		//创建一个Java代理
        /*Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BookFacadeImpl.class);
        enhancer.setCallback(new BookFacadeCglib());
        BookFacadeImpl target = (BookFacadeImpl) enhancer.create();*/
		
		BookFacadeImpl bookcglib = (BookFacadeImpl) cglib.getProxy(BookFacadeImpl.class);
		bookcglib.addBook();
        System.out.println("proxy class name:" + bookcglib.getClass().getName());
        
        
	}
}
