package com.sam.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({
	ElementType.TYPE,
	ElementType.METHOD,
	ElementType.CONSTRUCTOR,
	ElementType.FIELD
})
public @interface SmLogAnnocation {
	
	String username() default "小鱼";
	String value() default "sdfs";
	int[] hobbys() default {1,2,3,4};
	Person person() default Person.OTHER;
	BirthDay birthday() default @BirthDay(birthday="2018-08-09");
	
}
