package spring.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import spring.model.Student;

public interface StudentService {

	void saveStudent(Student student);

	List<Student> findAllStudents();

	void deleteStudentByName(String name);

	Student findByName(String name);

	void updateStudent(Student student);
	

}
