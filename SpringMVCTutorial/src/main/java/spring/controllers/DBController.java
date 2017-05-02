package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.database.DatabaseCaller;
import spring.model.*;

@Controller
public class DBController 
{
	@Autowired
	DatabaseCaller stu;
	
	@GetMapping("/database")
	public String database(Model model) 
	{
		UserFactory.newUser("Teacher", "Frank", "franky", "frankster", stu);
		UserFactory.newUser("Student", "Souneth", "soun", "badpassword", stu);
		UserFactory.newUser("Student", "Bob", "bob", "bob", stu);
		UserFactory.newUser("Dean", "The Dean", "deano", "Dean1!", stu);
		UserFactory.newUser("Dean", "Dean Shouldn't Exist", "shudntexist", "exists", stu);

;
		Student stew = (Student) stu.getStudentService().findByUserName("soun");
		model.addAttribute("student_name", stew.getName());
		model.addAttribute("student_username", stew.getUserName());
		
		Teacher teach = (Teacher) stu.getTeacherService().findByUserName("franky");
		model.addAttribute("teacher_name", teach.getName());
		model.addAttribute("teacher_username", teach.getUserName());
		
		Dean tempDean = (Dean) stu.getDeanService().getDean();
		model.addAttribute("dean_name", tempDean.getName());
		model.addAttribute("dean_username", tempDean.getUserName());
		
		
		return "database";
	}
}