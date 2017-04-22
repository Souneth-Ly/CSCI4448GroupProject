//package spring.dao;
//
//import java.util.List;
//import org.hibernate.Criteria;
////import org.hibernate.Query;
////import org.hibernate.criterion.Restrictions;
//import org.springframework.stereotype.Repository;
//
//import spring.model.Student;
//
//@Repository("StudentDao")
//public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao {
//
//
//
//	@Override
//	public Student findById(int id) {
//		return getByKey(id);
//	}
//
//	@Override
//	public void saveStudent(Student Student) {
//		
//		persist(Student);
//	}
//
//	@Override
//	public List<Student> findAllStudents() {
//		Criteria criteria = createEntityCriteria();
//        return (List<Student>) criteria.list();
//	}
//
//	
//}
//
