package com.valtech.training.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
	
//	whenever any method has dependency to another bean pass it as method argument like below
	@Bean
	public SimpleInterest simpleInterest(Arithmetic arithmetic) {
		return new SimpleInterestImpl(arithmetic);
	}
	
	@Bean
	public Arithmetic arithmetic() {
		return new ArithmeticImpl();
	}

}
