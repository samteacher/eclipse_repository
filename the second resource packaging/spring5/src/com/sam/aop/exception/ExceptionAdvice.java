package com.sam.aop.exception;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 异常通知
 * @author Administrator
 *
 */
public class ExceptionAdvice implements ThrowsAdvice{

	public void afterThrowing(Method method,Object[] params,Object obj,Exception ex){
		System.out.println("===============");
		System.out.println("method====="+method.getName());
		System.out.println("抛出的异常"+ex.getMessage());
		System.out.println("事务回滚.......");
	}
	
}
