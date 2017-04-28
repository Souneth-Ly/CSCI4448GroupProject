package spring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import spring.service.StudentService;
import spring.service.TeacherService;
import spring.service.DeanService;


@Component
public class DatabaseCaller {
	
	private StudentService studentserv;
	private TeacherService teacherserv;
	private DeanService deanserv;
	
	
	@Autowired
	private ApplicationContext appcontext;
	
	public DatabaseCaller(){

	}
	
	public StudentService getStudentService(){
		if(appcontext == null){
			System.out.println("Appcontext is null");
		}
		if(studentserv == null){
			studentserv = (StudentService) appcontext.getBean("studentService");
		}
		return studentserv;
	}
	
	public TeacherService getTeacherService(){
		if(appcontext == null){
			System.out.println("Appcontext is null");
		}
		if(teacherserv == null){
			teacherserv = (TeacherService) appcontext.getBean("teacherService");
		}
		return teacherserv;
	}
	
	public DeanService getDeanService(){
		if(appcontext == null){
			System.out.println("Appcontext is null");
		}
		if(deanserv == null){
			deanserv = (DeanService) appcontext.getBean("deanService");
		}
		return deanserv;
	}

	public ApplicationContext getContext(){
		return appcontext;
	}
	
	
	

}
