package spring.main;




import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
//import org.hibernate.cfg.Configuration;

import spring.config.AppConfig;


import spring.model.Student;
import spring.service.StudentService;


import java.util.List;

public abstract class AppMain {
	

	public static void main(String args[]) {

		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		


		StudentService stuService = (StudentService) context.getBean("studentService");
		
		stuService.deleteStudentByName("Joel Barkley");
		stuService.deleteStudentByName("Dimitri");
		
		
		Student student1 = new Student();
		student1.setName("Joel Barkley");
		student1.setUserName("joba4402");
		student1.setPassword("passwrd");
		student1.setReport("He is a pretty mediocre student");
		student1.setTuition(12000.92);
		
		Student student2 = new Student();
		student2.setName("Dimitri");
		student2.setUserName("dmta2921");
		student2.setPassword("root");
		student2.setReport("He is a much better student than Joel");
		student2.setTuition(12000.92);
		
		stuService.saveStudent(student1);
		stuService.saveStudent(student2);
		
		List<Student> students = stuService.findAllStudents();
		for (Student stu : students) {
			System.out.println(stu);
		}
		
		Student stew = stuService.findByName("Dimitri");
		stew.setReport("He is such a good student, he should have lower tuition");
		stew.setTuition(200.00);
		stuService.updateStudent(stew);
		
		System.out.println(stew);



		context.close();
	}
}
