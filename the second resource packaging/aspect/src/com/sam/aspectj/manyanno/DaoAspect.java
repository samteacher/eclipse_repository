package com.sam.aspectj.manyanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DaoAspect {

	
	@Before("execution(* com.sam.aspectj.manyanno.*.save*(..))")
	public void beforeAdvice(){
		System.out.println("======我要提交事务了!!!!======");
	}
	
}
