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


	private final StudentService studentService;
	
	public FirstController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/student")
	public StudentResponseDto saveStudent(
			@RequestBody StudentDto studentDto
	) {
		return this.studentService.saveStudent(studentDto);
	}
	

	@GetMapping("/student/{student-id}")
	public Student findStudentById(
			@PathVariable("student-id") Integer id
	) {
		
		return this.studentService.findStudentById(id);
	}
	
	@GetMapping("/students")
	public List<Student> findAllStudent() {
		
		return this.studentService.findAllStudent();
	}
	
	@GetMapping("/students/search/{student-name}")
	public List<Student> findStudentByName(
			@PathVariable("student-name") String name
	) {
		
		return this.studentService.findStudentByName(name);
	}
	
	@DeleteMapping("/student/{student-id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteById(
			@PathVariable("student-id") Integer id
	) {
		this.studentService.deleteById(id);
	}
}
