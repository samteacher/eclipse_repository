package com.sam.aspectj.annocglib;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DaoBeforeAspectAdvice {

	
	@Before("execution(* com.sam.aspectj.annocglib.*.*(..))")
	public void beforeAdvice(){
		System.out.println("======我要提交事务了!!!!======");
	}
	
}
