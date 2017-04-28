package spring.service;

import java.util.List;
import spring.model.Student;

public interface StudentService {

	void saveStudent(Student student);

	List<Student> findAllStudents();

	void deleteStudentByName(String name);

	Student findByUserName(String username);

	void updateStudent(Student student);
	
}
