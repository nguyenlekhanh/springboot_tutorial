package net.javaguides.springboot;

import org.springframework.http.HttpStatus;
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
	public Student post(
			@RequestBody Student student
	) {
		
		return repository.save(student);
		
		//return "Hello from my first controller";
	}
}
