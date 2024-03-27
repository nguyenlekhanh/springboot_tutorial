package net.javaguides.springboot.student;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		Mockito.verify(studentMapper, Mockito.times(1)).toStudent(dto);
		Mockito.verify(repository, Mockito.times(1)).save(student);
		Mockito.verify(studentMapper, Mockito.times(1)).toStudentResponseDto(savedStudent);
		
		
	}
	
	@Test
	public void should_return_all_student() {
		//Given
		List<Student> students = new ArrayList<>();
		students.add(new Student("Test", "Test", "Test@mail.com", 5));
		
		//Mock the calls
		Mockito.when(repository.findAll()).thenReturn(students);
		Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class)))
			.thenReturn(new StudentResponseDto(
						"Test", "Test", "Test@mail.com"
					));
		
		//When
		List<StudentResponseDto> responseDto = studentService.findAllStudent();
		
		//Then
		Assertions.assertEquals(students.size(), responseDto.size());
	}
	
	@Test
	public void should_return_student_by_id() {
		//Given
		Integer studentId = 1;
		Student student = new Student("Test", "Test", "Test@mail.com", 5);
		
		//Mock the calls
		Mockito.when(repository.findById(studentId))
			.thenReturn(Optional.of(student));
		Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class)))
			.thenReturn(new StudentResponseDto(
						"Test", "Test", "Test@mail.com"
					));
		
		//When
		StudentResponseDto dto = studentService.findStudentById(studentId);
		
		//Then
		Assertions.assertEquals(dto.firstName(), student.getFirstName());
		Assertions.assertEquals(dto.lastName(), student.getLastName());
		Assertions.assertEquals(dto.email(), student.getEmail());
	}
}
