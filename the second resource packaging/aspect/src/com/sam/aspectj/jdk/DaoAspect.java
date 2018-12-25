package com.sam.aspectj.jdk;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DaoAspect {

	@Before("execution(public * save*(..))")
	public void beforeAdvice(){
		System.out.println("jdk我要提交事务了");
	}
	
}
