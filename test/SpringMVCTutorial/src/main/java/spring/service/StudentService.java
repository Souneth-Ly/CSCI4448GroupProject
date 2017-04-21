package spring.service;

import java.util.List;

import spring.model.Student;

public interface StudentService {
	
	Student findById(int id);
    
    void saveStudent(Student Student);
     
    void updateStudent(Student Student);
     
    void deleteStudentBySsn(String ssn);
 
    List findAllStudents(); 
     
    Student findStudentById(int Id);
 
   

}