package spring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import spring.config.AppConfig;
import spring.config.ApplicationContextProvider;
import spring.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCaller {
	
	StudentService studentserv;
	

	
	
	@Autowired
	private ApplicationContext appcontext;
	
	public DatabaseCaller(){

	}
	
	public StudentService getStudentService(){
		if(appcontext == null){
			System.out.println("Appcontext is null");
		}
		studentserv = (StudentService) appcontext.getBean("studentService");
		return studentserv;
	}

	public ApplicationContext getContext(){
		return appcontext;
	}
	
	
	

}
