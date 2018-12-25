package com.sam.aop.around;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 
 * 环绕通知 
 * MethodInterceptor
 * @author Administrator
 *
 */
public class MethodInterceptorAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		//执行的类
		System.out.println("执行的类"+invocation.getThis().getClass().getName());
		//执行方法
		Method method = invocation.getMethod();
		System.out.println("执行的方法"+method.getName());
		//执行目标方法参数
		Object[] params = invocation.getArguments();
		
		System.out.println("开启事务...");
		Object obj = invocation.proceed();
		System.out.println("提交完毕...");
		System.out.println("=========================");
		return obj;
		
	}

}
