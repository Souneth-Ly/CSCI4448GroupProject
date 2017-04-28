package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.StudentDao;
import spring.model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao dao;
	


	
	public void saveStudent(Student student) {
		dao.saveStudent(student);
	}

	public List<Student> findAllStudents() {
		return dao.findAllStudents();
	}

	public void deleteStudentByName(String name) {
		dao.deleteStudentByName(name);
	}

	public Student findByName(String name) {
		return dao.findByName(name);
	}

	public void updateStudent(Student student){
		dao.updateStudent(student);
	}
}
