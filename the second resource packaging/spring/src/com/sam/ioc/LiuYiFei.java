package com.sam.ioc;

public class LiuYiFei extends XiaoQiao {

	private boolean format_sql; 	
	private boolean show_sql;
	
	public void sayHello(){
		
		System.out.println("我是小乔的扮演者,刘亦菲！！！");
	}
	
	
	public void init() {
		format_sql = false;
		show_sql = true;
		System.out.println("我是在容器启动的时候就初始化了.....");
	}
}
