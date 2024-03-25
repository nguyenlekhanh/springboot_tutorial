package net.javaguides.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean("mybean")
	public MyFirstClass myFirstClass() {
		return new MyFirstClass("First Bean");
	}
}
