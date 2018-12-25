package com.sam.aspectj.annocglib;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DaoARoundAdvice {
	
	
	@Pointcut("execution(* update*(..))")  
    public void pcMethod(){};  
    @Around("pcMethod()")  
    public void test(ProceedingJoinPoint pjp){  
//        long time = System.currentTimeMillis();  
        System.out.println("【事务提交开始】");
        try {  
            pjp.proceed();  
        } catch (Throwable e) {  
            e.printStackTrace();  
        }  
        //time = System.currentTimeMillis() - time; 
        System.out.println("【事务提交结束】");
//        System.out.printf("方法执行耗时:%d毫秒",time);  
    }  
}
