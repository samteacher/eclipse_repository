package com.sam.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {

	public static void main(String[] args) {
		
//		boolean falg = TzStringUtils.isMobile("15935831827");
//		System.out.println(falg);
		
		List<String> list = new ArrayList<String>(2);
		list.add("guan");
		list.add("bao");
		String[] array = new String[list.size()];
		array = list.toArray(array);
		
		System.out.println(list);
		System.out.println(array);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		System.out.println(map);
		
		switch (1) {
		case 1:
			break;
		case 2:
			return;
		default:
			break;
		}
		
		
	}
}
