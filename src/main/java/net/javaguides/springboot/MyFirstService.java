package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

	private final MyFirstClass myFirstClass;
	
	public MyFirstService(MyFirstClass myFirstClass) {
		this.myFirstClass = myFirstClass;
	}
	
	public String tellAStory() {
		return "The Dependency is saying: " + myFirstClass.sayHello();
	}
}
