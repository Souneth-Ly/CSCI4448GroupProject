package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.TeacherDao;
import spring.model.Teacher;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherDao dao;
	
	
	public void saveTeacher(Teacher teacher) {
		dao.saveTeacher(teacher);
	}

	public List<Teacher> findAllTeachers() {
		return dao.findAllTeachers();
	}

	public void deleteTeacherByName(String name) {
		dao.deleteTeacherByName(name);
	}

	public Teacher findByUserName(String username) {
		return dao.findByUserName(username);
	}

	public void updateTeacher(Teacher teacher){
		dao.updateTeacher(teacher);
	}
}
