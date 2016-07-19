package com.abhay.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abhay.spring.classes.ClassA;
import com.abhay.spring.classes.ClassB;
import com.abhay.spring.config.BeanConfig;

public class MainApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(BeanConfig.class);
		ClassA beanA = ctxt.getBean(ClassA.class);
		ClassB beanB = ctxt.getBean(ClassB.class);
		
		System.out.println(beanA + "\n" + beanB);
		
		// Following should be true as beans are singletons and Spring intercepts
		// methods annotated as @Bean
		if (beanB.getObjA() == beanA)
			System.out.println("Test successful");
		else
			System.out.println("Some weird failure");
	}

}
