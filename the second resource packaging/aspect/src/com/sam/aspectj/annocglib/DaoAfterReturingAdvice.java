package com.sam.aspectj.annocglib;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class DaoAfterReturingAdvice {

	
	@AfterReturning("execution(* com.sam.aspectj.annocglib.*.*(..))")
	public void beforeAdvice(){
		System.out.println("======事务提交成功!!!!======");
	}
	
}
