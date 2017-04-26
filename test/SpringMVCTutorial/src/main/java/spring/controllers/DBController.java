package spring.controllers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import spring.database.DatabaseCaller;
import spring.config.AppConfig;
import spring.model.*;
import spring.service.StudentService;


@Controller
public class DBController 
{
	
	
	@Autowired
	DatabaseCaller stu;
	
	@GetMapping("/database")
	public String database(Model model) 
	{
		Student stew = (Student) stu.getStudentService().findByName("Dimitri");
		model.addAttribute("name", stew.getName());
		model.addAttribute("username", stew.getUserName());
		return "database";
	}

}