package net.javaguides.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	
	@GetMapping("/hello")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String sayHello() {
		return "Hello from my first controller";
	}
}
