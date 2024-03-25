package net.javaguides.springboot;

public record StudentDto(
		String firstName,
		String lastName,
		String email,
		int age,
		Integer schoolId
) {

}
