package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import spring.model.Teacher;

@Repository("teacherDao")
public class TeacherDaoImpl extends AbstractDao implements TeacherDao{

	public void saveTeacher(Teacher teacher) {
		if(findByUserName(teacher.getUserName())==null){
			persist(teacher);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Teacher> findAllTeachers() {
		Criteria criteria = getSession().createCriteria(Teacher.class);
		return (List<Teacher>) criteria.list();
	}

	public void deleteTeacherByName(String name) {
		Query query = getSession().createSQLQuery("delete from Teacher where name = :name");
		query.setString("name", name);
		query.executeUpdate();
	}
	
	public Teacher findByUserName(String username){
		Criteria criteria = getSession().createCriteria(Teacher.class);
		criteria.add(Restrictions.eq("userName",username));
		return (Teacher)criteria.uniqueResult();
	}

	
	public void updateTeacher(Teacher teacher){
		getSession().update(teacher);
	}
	
}
