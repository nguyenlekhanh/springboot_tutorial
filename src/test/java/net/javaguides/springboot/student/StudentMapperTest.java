package net.javaguides.springboot.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {

	private StudentMapper studentMapper;

	
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
		studentMapper = new StudentMapper();
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
	
	
	@Test
	public void shouldMapStudentDtoToStudent() {
		StudentDto dto = new StudentDto("Test", "Test", "Test", 1, 1);
		
		Student student = studentMapper.toStudent(dto);
		
		Assertions.assertEquals(dto.firstName(), student.getFirstName());
		Assertions.assertEquals(dto.lastName(), student.getLastName());
		Assertions.assertEquals(dto.email(), student.getEmail());
		Assertions.assertNotNull(student.getSchool());
		Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());
		
	}
	
	@Test
	public void should_throw_null_pointer() {
		//Assertions.assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
		var exp = Assertions.assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
		Assertions.assertEquals("The student is null", exp.getMessage());
	}
}
