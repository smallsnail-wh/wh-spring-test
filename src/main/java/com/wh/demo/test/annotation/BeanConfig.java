package com.wh.demo.test.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {

	@Bean
	@Primary
	public PrimayTest primayTest1() {
		PrimayTest primayTest = new PrimayTest();
		primayTest.setI(1);
		return primayTest;
	}
	
	@Bean
	public PrimayTest primayTest2() {
		PrimayTest primayTest = new PrimayTest();
		primayTest.setI(2);
		return primayTest;
	}
	
}
