package net.javaguides.springboot.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class StudentServiceTest {

	@InjectMocks
	private StudentService studentService;
	
	@Mock
	private StudentRepository repository;
	
	@Mock
	private StudentMapper studentMapper;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void should_successfully_save_a_student() {
		//Given
		StudentDto dto = new StudentDto("Test", "Test", "Test@mail.com", 5, 1);
		
		Student student = new Student("Test", "Test", "Test@mail.com", 5);
		
		Student savedStudent = new Student("Test", "Test", "Test@mail.com", 5);
		savedStudent.setId(1);
		
		// Mock the calls
		Mockito.when(studentMapper.toStudent(dto)).thenReturn(student);
		Mockito.when(repository.save(student)).thenReturn(savedStudent);
		Mockito.when(studentMapper.toStudentResponseDto(savedStudent))
			.thenReturn(new StudentResponseDto("Test", "Test", "Test@mail.com"));
		
	
		//When
		StudentResponseDto responseDto = studentService.saveStudent(dto);
		
		//then
		Assertions.assertEquals(dto.firstName(), responseDto.firstName());
		Assertions.assertEquals(dto.lastName(), responseDto.lastName());
		Assertions.assertEquals(dto.email(), responseDto.email());
		
	}
}
