package com.abhay.spring.config;

import com.abhay.spring.classes.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public ClassA classA()
	{
		System.out.println("Should print only once"); // As Spring intercepts calls to @Bean methods and ensures singleton
		return new ClassA(10, "bean A");
	}
	
	@Bean
	public ClassB classB()
	{
		return new ClassB(classA(), "bean B");
	}
}
