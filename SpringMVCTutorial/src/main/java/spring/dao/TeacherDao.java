package spring.dao;

import java.util.List;
import spring.model.Teacher;

public interface TeacherDao {

	void saveTeacher(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	
	void deleteTeacherByName(String name);
	
	Teacher findByUserName(String username);
	
	void updateTeacher(Teacher student);
}
