package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(Demo2Application.class, args);
		
		MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
		SpringApplication.run(Demo2Application.class, args);
	}

}
