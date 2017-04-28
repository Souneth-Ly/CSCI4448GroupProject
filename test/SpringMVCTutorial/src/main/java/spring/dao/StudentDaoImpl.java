package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import spring.model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao implements StudentDao{

	public void saveStudent(Student student) {
		persist(student);
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		Criteria criteria = getSession().createCriteria(Student.class);
		return (List<Student>) criteria.list();
	}

	public void deleteStudentByName(String name) {
		Query query = getSession().createSQLQuery("delete from Student where name = :name");
		query.setString("name", name);
		query.executeUpdate();
	}

	
	public Student findByName(String name){
		Criteria criteria = getSession().createCriteria(Student.class);
		criteria.add(Restrictions.eq("name",name));
		return (Student) criteria.uniqueResult();
	}
	
	public void updateStudent(Student student){
		getSession().update(student);
	}
	
}
