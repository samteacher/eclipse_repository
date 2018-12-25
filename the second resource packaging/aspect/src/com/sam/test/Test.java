package com.sam.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Test {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		Class clz = TestService.class;
		SmLogAnnocation smLogAnnocation = (SmLogAnnocation) clz.getAnnotation(SmLogAnnocation.class);
		System.out.println(smLogAnnocation.username());
		System.out.println(smLogAnnocation.value());
		System.out.println(Arrays.toString(smLogAnnocation.hobbys()));
		System.out.println(smLogAnnocation.person().getName());
		System.out.println(smLogAnnocation.birthday().birthday());
		
		System.out.println("=====================");
		
		Constructor con = clz.getConstructor();
		SmLogAnnocation cAnnocation = (SmLogAnnocation) con.getAnnotation(SmLogAnnocation.class);
		System.out.println(cAnnocation.value());
		
		System.out.println("=====================");
		
		Field[] fields = clz.getDeclaredFields();
		for (Field field : fields) {
			SmLogAnnocation fAnnocation = (SmLogAnnocation) field.getAnnotation(SmLogAnnocation.class);
			System.out.println(fAnnocation.username());
			System.out.println(fAnnocation.value());
		}
		
		System.out.println("=====================");
		
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods) {
			SmLogAnnocation mAnnocation = (SmLogAnnocation) method.getAnnotation(SmLogAnnocation.class);
			System.out.println(mAnnocation.value());
		}
		
		
//		System.out.println(Person.MAN.getName());
//		System.out.println(Person.WOMAN.getName());
//		System.out.println(Person.OTHER.getName());
	}
}
