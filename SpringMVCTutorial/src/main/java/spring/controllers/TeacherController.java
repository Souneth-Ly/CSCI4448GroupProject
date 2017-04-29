package spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import spring.database.DatabaseCaller;
import spring.model.Student;
import spring.model.Teacher;



@Controller("/teacher")
public class TeacherController {
	
	@Autowired
	DatabaseCaller stu;
    

	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String teacher(Model model, HttpSession session) 
	{
		if(!(session.getAttribute("user") instanceof Teacher)){
			return "redirect:/login";
		}
		Teacher t = (Teacher) session.getAttribute("user");
		model.addAttribute("name", t.getName());
		model.addAttribute("username", t.getUserName());
		model.addAttribute("password", t.getPassword());
		return "teacher";
	}
	
	@GetMapping("/studentreport")
	public String teacherreport(Model model) 
	{
		return "studentreport";
	}
	
	
	@RequestMapping("/studentreport")
    public String submit(Model model, @RequestParam("userName") String username, @RequestParam("Report") String report, @RequestParam("Grade") String grade){
		Student stew = (Student) stu.getStudentService().findByUserName(username);
		stew.setReport(report);
		stew.setGrade(grade);
		stu.getStudentService().updateStudent(stew);
    	return "redirect:/teacher";
    }
	
	@RequestMapping(value = "/viewteacherreport", method = RequestMethod.GET)
	public String viewstudentreport(Model model, HttpSession session) 
	{
		if(!(session.getAttribute("user") instanceof Teacher)){
			return "redirect:/login";
		}
		Teacher t = (Teacher) session.getAttribute("user");
		if(t.getReport()==null){
			model.addAttribute("msg", "Hello, " + t.getName() + ".  There is not current a report from the dean on file." );
		}else{
			model.addAttribute("msg", "Hello, " + t.getName() + ".  Your current semester report from the Dean is as follows: " + t.getReport() );
		}
		return "viewteacherreport";
	}
	
	@GetMapping("/changeteacherpassword")
	public String changeteacherpassword(Model model) 
	{
		return "changeteacherpassword";
	}
	
	@RequestMapping("/changeteacherpassword")
    public String changeteacherpassword(Model model, @RequestParam("old_password") String oldpassword, 
    		@RequestParam("new_password") String newpassword, 
    		@RequestParam("confirm_new_password") String confirmnewpassword, HttpSession session){
		Teacher t = (Teacher) session.getAttribute("user");
		if(t.getPassword().equals(oldpassword) && newpassword.equals(confirmnewpassword)){
			t.setPassword(newpassword);
			stu.getTeacherService().updateTeacher(t);
		}
    	return "redirect:/teacher";
    }
	
    

}
