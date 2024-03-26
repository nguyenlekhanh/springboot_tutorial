package net.javaguides.springboot;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.javaguides.springboot.student.StudentDto;
import net.javaguides.springboot.student.StudentResponseDto;
import net.javaguides.springboot.student.StudentService;

@RestController
public class FirstController {


	private final StudentService studentService;
	
	public FirstController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/student")
	public StudentResponseDto saveStudent(
			@Valid @RequestBody StudentDto studentDto
	) {
		return this.studentService.saveStudent(studentDto);
	}

	@GetMapping("/student/{student-id}")
	public StudentResponseDto findStudentById(
			@PathVariable("student-id") Integer id
	) {
		
		return this.studentService.findStudentById(id);
	}
	
	@GetMapping("/students")
	public List<StudentResponseDto> findAllStudent() {
		
		return this.studentService.findAllStudent();
	}
	
	@GetMapping("/students/search/{student-name}")
	public List<StudentResponseDto> findStudentByName(
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exp
	) {
		var errors = new HashMap<String, String>();
		exp.getBindingResult().getAllErrors()
				.forEach(error -> {
					var fieldName = ((FieldError) error).getField();
					var errorMessage = error.getDefaultMessage();
					errors.put(fieldName, errorMessage);
				});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
