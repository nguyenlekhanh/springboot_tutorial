package net.javaguides.springboot.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {

//	@BeforeAll
//	void beforeAll() {
//		System.out.println("Inside the before all method");
//	}
	
//	@AfterAll
//	void beforeAll() {
//		System.out.println("Inside the after all method");
//	}
	
	@BeforeEach
	void setUp() {
		System.out.println("Inside the before each method");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Inside the after each method");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("My first test method");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("My second test method");
	}
}
