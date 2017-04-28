package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import spring.database.DatabaseCaller;
import spring.model.Teacher;


@Controller("/teacherteport")
public class TeacherReportController 
{
	
	@Autowired
	DatabaseCaller stu;
	
	
	@GetMapping("/teacherreport")
	public String teacherreport(Model model) 
	{
		return "teacherreport";
	}
	

	@RequestMapping("/teacherreport")
    public String submit(Model model, @RequestParam("userName") String username, @RequestParam("Report") String report){
		Teacher teach = (Teacher) stu.getTeacherService().findByUserName(username);
		teach.setReport(report);
		stu.getTeacherService().updateTeacher(teach);
    	return "redirect:/dean";
    }

}