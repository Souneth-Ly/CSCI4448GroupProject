package spring.dao;

import java.util.List;
import spring.model.Student;

public interface StudentDao {

	void saveStudent(Student student);
	
	List<Student> findAllStudents();
	
	void deleteStudentByName(String name);
	
	Student findByName(String name);
	
	void updateStudent(Student student);
}
