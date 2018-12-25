package com.sam.annotation;

public enum Gender {
	MAN{
		public String getName(){
			return "男";
		}
	},WOMAN{
		public String getName(){
			return "女";
		}
	},OTHER{
		public String getName(){
			return "保密";
		}
	};
	
	public abstract String getName();
}
