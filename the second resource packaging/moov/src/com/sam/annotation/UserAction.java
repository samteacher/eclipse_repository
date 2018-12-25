package com.sam.annotation;

@SamAnnotation("method-useraction")
public class UserAction {

	@SamAnnotation("field-age")
	private Integer age;
	
	@SamAnnotation("constructor-useraction")
	public UserAction() {
		super();
	}
	
	@SamAnnotation("method-save")
	public String save(@SamAnnotation("id") String id){
		System.out.println("进入List方法" + id);
		return "list";
	}
	
}
