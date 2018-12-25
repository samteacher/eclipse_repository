package com.sam.aop.after;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * MethodBeforeAdvice  后置通知
 * @author Administrator
 *
 */
public class AfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object obj, Method method, Object[] args,
			Object target) throws Throwable {
		System.out.println("【后置通知】"+target.getClass().getName()+"的业务逻辑方法是"+method.getName()+"保存日记");
		
		if(args!=null){
			for (Object object : args) {
				System.out.println("========"+String.valueOf(object));
			}
		}
		
	}
	
}
