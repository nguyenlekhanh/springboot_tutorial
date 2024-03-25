package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(Demo2Application.class, args);
		
		//MyFirstClass myFirstClass = ctx.getBean("mybean", MyFirstClass.class);'
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
//		System.out.println(myFirstService.getJavaVersion());
//		System.out.println(myFirstService.getOsName());
//		System.out.println(myFirstService.readProp());
		
		System.out.println(myFirstService.getCustomerProperty());
		System.out.println(myFirstService.getCustomerPropertyInt());
		SpringApplication.run(Demo2Application.class, args);
	}

}
