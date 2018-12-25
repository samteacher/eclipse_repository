package com.sam.annotation;

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
public @interface LogAnnotation {
	
	String username() default "";
	String value() default "";
	BirthDay birthday() default @BirthDay(birthday="2012-12-12");
	Gender male() default Gender.OTHER;//枚举类
	int[] hobbys() default {1,2,3};

}
