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
	
	@GetMapping("/hello")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String sayHello() {
		return "Hello from my first controller";
	}
	
	@PostMapping("/post")
	public String post(
			@RequestBody Order order
	) {
		return "Hello from post: " + order.toString();
	}
	
	@GetMapping("/hello/{user-name}")
	public String pathVar(
			@PathVariable("user-name") String userName
	) {
		return "my value = " + userName;
	}

	//hello?user-name=value&user-lastname=value
	@GetMapping("/hello")
	public String paramVar(
			@RequestParam("user-name") String userName,
			@RequestParam("user-lastname") String userLastName
	) {
		return "my value = " + userName;
	}
}
