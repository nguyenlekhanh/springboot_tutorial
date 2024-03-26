package net.javaguides.springboot;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {

	private final StudentRepository repository;
	private final StudentMapper studentMapper;
	
	public StudentService(StudentRepository repository, StudentMapper studentMapper) {
		this.repository = repository;
		this.studentMapper = studentMapper;
	}
	
	public StudentResponseDto saveStudent(StudentDto studentDto) {
		var student = this.studentMapper.toStudent(studentDto);
		var savedStudent = this.repository.save(student);
		return this.studentMapper.toStudentResponseDto(savedStudent);
	}
	
	public StudentResponseDto findStudentById(
			Integer id
	) {
		
		return this.repository.findById(id)
				.map(studentMapper::toStudentResponseDto)
				.orElse(null);
	}
	
	public List<StudentResponseDto> findAllStudent() {
		
		return this.repository.findAll()
					.stream()
					.map(studentMapper::toStudentResponseDto)
					.collect(Collectors.toList());
	}
	
	public List<StudentResponseDto> findStudentByName(
			String name
	) {
		
		return this.repository.findAllByFirstNameContaining(name)
				.stream()
				.map(studentMapper::toStudentResponseDto)
				.collect(Collectors.toList());
	}
	
	public void deleteById(
			Integer id
	) {
		this.repository.deleteById(id);
	}
}
