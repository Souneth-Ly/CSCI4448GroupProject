package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import spring.database.DatabaseCaller;
import spring.model.Student;


@Controller("/studentreport")
public class StudentReportController 
{
	
	@Autowired
	DatabaseCaller stu;
	
	@GetMapping("/studentreport")
	public String teacherreport(Model model) 
	{
		return "studentreport";
	}
	
	
	@RequestMapping("/studentreport")
    public String submit(Model model, @RequestParam("userName") String username, @RequestParam("Report") String report){
		Student stew = (Student) stu.getStudentService().findByUserName(username);
		stew.setReport(report);
		stu.getStudentService().updateStudent(stew);
    	return "redirect:/teacher";
    }

}