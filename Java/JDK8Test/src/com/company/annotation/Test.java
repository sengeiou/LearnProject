package com.company.annotation;

import com.company.annotation.SimpleAnnotation;
import java.lang.reflect.*;
import java.lang.annotation.*;

public class Test{
	
	@SimpleAnnotation(name="cocoa", age=30)
	public void test(){
	}

	public static void main(String[] args) throws Exception{
	
		Method method = Test.class.getMethod("test",new Class[]{});		
		System.out.println(method.isAnnotationPresent(SimpleAnnotation.class));
		if(method.isAnnotationPresent(SimpleAnnotation.class)){
			System.out.println(method.getAnnotation(SimpleAnnotation.class));
			System.out.println(method.getAnnotation(SimpleAnnotation.class).annotationType());

			SimpleAnnotation annotation = method.getAnnotation(SimpleAnnotation.class);

			System.out.println(annotation.name()+annotation.age());

		}
	}
}
