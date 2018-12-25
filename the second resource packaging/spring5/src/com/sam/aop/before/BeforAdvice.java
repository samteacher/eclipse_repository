package com.sam.aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * MethodBeforeAdvice  前置通知
 * @author Administrator
 *
 */
public class BeforAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object object)
			throws Throwable {
		System.out.println("【前置通知】"+object.getClass().getName()+"的业务逻辑方法是"+method.getName()+"保存日记");
	}

	
}
