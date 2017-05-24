package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);

		TsetServer t1 = context.getBean(TsetServer.class);
		TsetServer t2 = context.getBean(TsetServer.class);

		System.out.println(t1 == t2);

	}
}
