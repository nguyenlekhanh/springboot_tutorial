package net.javaguides.springboot;

public class MyFirstClass {

	private String myVar;
	
	public MyFirstClass(String myVar) {
		this.myVar = myVar;
	}
	
	public String sayHello() {
		return "Hello - MyFirstClass => myVar = " + myVar;
	}
}
