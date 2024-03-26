package net.javaguides.springboot;

import java.util.List;

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
	
	public Student findStudentById(
			Integer id
	) {
		
		return this.repository.findById(id).orElse(null);
	}
	
	public List<Student> findAllStudent() {
		
		return this.repository.findAll();
	}
	
	public List<Student> findStudentByName(
			String name
	) {
		
		return this.repository.findAllByFirstNameContaining(name);
	}
	
	public void deleteById(
			Integer id
	) {
		this.repository.deleteById(id);
	}
}
