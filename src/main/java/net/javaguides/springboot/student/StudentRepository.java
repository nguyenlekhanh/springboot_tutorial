package net.javaguides.springboot.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	List<Student> findAllByFirstNameContaining(String firstName);
}