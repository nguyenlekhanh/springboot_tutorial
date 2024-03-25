package net.javaguides.springboot;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


	private final StudentRepository repository;
	
	public FirstController(StudentRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/student")
	public StudentResponseDto post(
			@RequestBody StudentDto studentDto
	) {
		var student = toStudent(studentDto);
		var savedStudent = repository.save(student);
		return toStudentResponseDto(savedStudent);
	}
	
	private Student toStudent(StudentDto dto) {
		var student = new Student();
		student.setFirstName(dto.firstName());
		student.setLastName(dto.lastName());
		student.setEmail(dto.email());
		student.setAge(dto.age());
		
		var school = new School();
		school.setId(dto.schoolId());
		
		student.setSchool(school);
		
		return student;
	}
	
	private StudentResponseDto toStudentResponseDto(Student student) {
		return new StudentResponseDto(
					student.getFirstName(),
					student.getLastName(),
					student.getEmail()
				);
	}
	
	@GetMapping("/student/{student-id}")
	public Student findStudentById(
			@PathVariable("student-id") Integer id
	) {
		
		return repository.findById(id).orElse(null);
	}
	
	@GetMapping("/students")
	public List<Student> findAllStudent() {
		
		return repository.findAll();
	}
	
	@GetMapping("/students/search/{student-name}")
	public List<Student> findStudentByName(
			@PathVariable("student-name") String name
	) {
		
		return repository.findAllByFirstNameContaining(name);
	}
	
	@DeleteMapping("/student/{student-id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(
			@PathVariable("student-id") Integer id
	) {
		repository.deleteById(id);
	}
}
