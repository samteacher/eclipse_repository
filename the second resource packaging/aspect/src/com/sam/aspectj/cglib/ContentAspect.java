package com.sam.aspectj.cglib;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ContentAspect {

	@Before("execution(* save*(..))")
	public void beforeAdvice(){
		System.out.println("我要看清结果了");
	}
	
}
