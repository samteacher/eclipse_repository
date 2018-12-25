package com.sam.annotation;

public class AnnocationTest {

	public static void main(String[] args) {
		
		System.out.println("============= 获取类注解的值 =============");
		Class<UserAction> clz = UserAction.class;
		SamAnnotation logAnnotation = (SamAnnotation) clz.getAnnotation(SamAnnotation.class);
		
		System.out.println(logAnnotation.value());
		
	}
}
