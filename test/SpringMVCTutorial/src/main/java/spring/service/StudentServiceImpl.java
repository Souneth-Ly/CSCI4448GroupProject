//package spring.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import spring.dao.StudentDao;
//import spring.model.Student;
//
//@Service("StudentService")
//@Transactional
//public class StudentServiceImpl implements StudentService {
//	
//	@Autowired
//    private StudentDao dao;
//
////	@Override
////	public void deleteStudentBySsn(String ssn) {
////		// TODO Auto-generated method stub
////		dao.deleteStudentBySsn(ssn);
////	}
//
//	@Override
//	public Student findById(int id) {		
//		return dao.findById(id);
//	}
//
//	@Override
//	public void saveStudent(Student Student) {
//		// TODO Auto-generated method stub
//		 dao.saveStudent(Student);
//	}
//
//	@Override
//	public void updateStudent(Student Student) {
//		// TODO Auto-generated method stub
//		Student entity = dao.findById(Student.getId());
//        if(entity!=null){
//            entity.setName(Student.getName());
//            entity.setJoiningDate(Student.getJoiningDate());
//            entity.setSalary(Student.getSalary());
//            entity.setSsn(Student.getSsn());
//        }
//		
//	}
//
//	@Override
//	public List findAllStudents() {
//		return dao.findAllStudents();
//	}
//
//	@Override
//	public Student findStudentById(int id) {
//		return dao.findStudentBySsn(ssn);
//	}
//	
//
//
//}
