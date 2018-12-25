package com.sam.aop.cjlib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 代理类 输出日志
 * cglib代理
 * @author Administrator
 *
 */
public class BookFacadeCglib implements MethodInterceptor {

	//通过Enhancer 创建代理对象
	private Enhancer enhancer = new Enhancer();
 
	//通过Class对象获取代理对象
	public Object getProxy(Class c){
        //设置创建子类的类
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("日志开始...");
        //代理类调用父类的方法
        proxy.invokeSuper(obj, args);
        System.out.println("日志结束...");
        return null;
	}

}
