package com.company.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleAnnotation{
	
	public String name() default "";
	public int age() default 1;
}
