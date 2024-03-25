package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

	private MyFirstClass myFirstClass;
	
	private Environment environment;
	
	@Value("${my.custom.property}")
	private String customerProperty;
	
	@Value("${my.custom.property.int}")
	private Integer customerPropertyInt;
	
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
	
	public String getOsName() {
		return environment.getProperty("os.name");
	}
	
	public String readProp() {
		return environment.getProperty("my.custom.property");
	}
	
	@Autowired
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getCustomerProperty() {
		return customerProperty;
	}

	public Integer getCustomerPropertyInt() {
		return customerPropertyInt;
	}
}
