package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

	private MyFirstClass myFirstClass;
	
	private Environment environment; 
	
	@Autowired
	public void injectDependencies (
			@Qualifier("mySecondBean") MyFirstClass myFirstClass
	) {
		this.myFirstClass = myFirstClass;
	}
	
	public String tellAStory() {
		return "The Dependency is saying: " + myFirstClass.sayHello();
	}
	
	public String getJavaVersion() {
		return environment.getProperty("java.version");
	}
	
	@Autowired
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
