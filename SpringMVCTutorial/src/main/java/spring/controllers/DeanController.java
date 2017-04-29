package spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import javax.servlet.http.HttpSession;

import spring.database.DatabaseCaller;
import spring.model.Dean;
import spring.model.Teacher;
import spring.model.UserFactory;
import spring.model.Student;


@Controller("/dean")
public class DeanController {
	
	@Autowired
	DatabaseCaller stu;
    
	
	@RequestMapping(value = "/dean", method = RequestMethod.GET)
	public String dean(Model model, HttpSession session) 
	{
		if(!(session.getAttribute("user") instanceof Dean)){
			return "redirect:/login";
		}
		Dean d = (Dean) session.getAttribute("user");
		model.addAttribute("name", d.getName());
		model.addAttribute("username", d.getUserName());
		model.addAttribute("password", d.getPassword());
		return "dean";
	}
	
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
	
	@GetMapping("/settuition")
	public String settuition(Model model) 
	{
		return "settuition";
	}
	

	@RequestMapping("/settuition")
    public String submit(Model model, @RequestParam("Specify Amount") double amount){
		List<Student> studentlist =  stu.getStudentService().findAllStudents();
		for(Student s : studentlist){
			s.setTuition(amount);
			stu.getStudentService().updateStudent(s);
		}
    	return "redirect:/dean";
    }
	
	@GetMapping("/createuser")
	public String createuser(Model model) 
	{
		return "createuser";
	}
	

	@RequestMapping("/createuser")
    public String submit(Model model, @RequestParam("type") String type, @RequestParam("name") String name
    		, @RequestParam("username") String username, @RequestParam("password") String password){
		UserFactory.newUser(type, name, username, password, stu);
    	return "redirect:/dean";
    }
	
	@GetMapping("/changedeanpassword")
	public String changedeanpassword(Model model) 
	{
		return "changedeanpassword";
	}
	

	@RequestMapping("/changedeanpassword")
    public String changepassword(Model model, @RequestParam("old_password") String oldpassword, 
    		@RequestParam("new_password") String newpassword, 
    		@RequestParam("confirm_new_password") String confirmnewpassword, HttpSession session){
		Dean d = (Dean) session.getAttribute("user");
		if(d.getPassword().equals(oldpassword) && newpassword.equals(confirmnewpassword)){
			d.setPassword(newpassword);
			stu.getDeanService().updateDean(d);
		}
    	return "redirect:/dean";
    }
	
    

}
