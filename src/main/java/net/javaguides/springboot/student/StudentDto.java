package net.javaguides.springboot.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
		String firstName,
		String lastName,
		String email,
		int age,
		Integer schoolId
) {

}
