package com.sam.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) throws Exception, SecurityException {
		
		System.out.println("============= 获取类注解的值 =============");
		Class clz = UserService.class;
		LogAnnotation logAnnotation = (LogAnnotation) clz.getAnnotation(LogAnnotation.class);
		System.out.println(logAnnotation.username());
		System.out.println(logAnnotation.value());
		System.out.println(logAnnotation.male().getName());
		System.out.println(Arrays.toString(logAnnotation.hobbys()));
		BirthDay birthDay = logAnnotation.birthday();
		System.out.println(birthDay.birthday());
		
		
		System.out.println("============= 获取构造函数注解的值 =============");
		Constructor con = clz.getConstructor();
		LogAnnotation cAnnotation = (LogAnnotation) con.getAnnotation(LogAnnotation.class);
		System.out.println(logAnnotation.username());
		System.out.println(logAnnotation.value());
		
		
		System.out.println("============= 获取属性注解的值 =============");
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			LogAnnotation fAnnotation = (LogAnnotation) field.getAnnotation(LogAnnotation.class);
			System.out.println(fAnnotation.username());
			System.out.println(fAnnotation.value());
		}
		
		
		System.out.println("============= 获取方法注解的值 =============");
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods) {
			LogAnnotation mAnnotation = (LogAnnotation) method.getAnnotation(LogAnnotation.class);
			System.out.println(mAnnotation.username());
			System.out.println(mAnnotation.value());
			Annotation[][] an = method.getParameterAnnotations();
			for (int i = 0; i < an.length; i++) {
				for (int j = 0; j < an[i].length; j++) {
					Parameter parameter = (Parameter) an[i][j];
					System.out.println(parameter.value());
				}
			}
			
//			Parameter parameter = (Parameter) methods2[0][0];
//			System.out.println(parameter.value());
		}
		
		
		System.out.println(Gender.MAN.getName());
		System.out.println(Gender.WOMAN.getName());
		
	}
}
