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
import spring.model.Dean;
import spring.model.Student;



@Controller("/student")
public class StudentController {
	
	@Autowired
	DatabaseCaller stu;
    

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student(Model model, HttpSession session) 
	{
		if(!(session.getAttribute("user") instanceof Student)){
			return "redirect:/login";
		}
		Student s = (Student) session.getAttribute("user");
		model.addAttribute("name", s.getName());
		model.addAttribute("username", s.getUserName());
		model.addAttribute("password", s.getPassword());
		
		return "student";
	}
	
	@RequestMapping(value = "/viewstudentreport", method = RequestMethod.GET)
	public String viewstudentreport(Model model, HttpSession session) 
	{
		if(!(session.getAttribute("user") instanceof Student)){
			return "redirect:/login";
		}
		Student s = (Student) session.getAttribute("user");
		if(s.getReport()==null){
			model.addAttribute("msg", "Hello, " + s.getName() + ".  There is not current a report or grade from your teacher on file." );
		}else{
			model.addAttribute("msg", "Hello, " + s.getName() + ".  Your current semester report from the Dean is as follows: " + s.getReport() );
			model.addAttribute("grade", "Your Grade for the semester was: " + s.getGrade());
		}
		return "viewstudentreport";
	}
	
	@GetMapping("/paytuition")
	public String paytuition(Model model, HttpSession session) 
	{
		if(!(session.getAttribute("user") instanceof Student)){
			return "redirect:/login";
		}
		Student stew = (Student) session.getAttribute("user");
		double tuition = stew.getTuition();
		model.addAttribute("tuition", "Your current tuition balance is: " + tuition);
		return "paytuition";
	}
	
	
	@RequestMapping("/paytuition")
    public String submit(Model model, @RequestParam("Pay Amount") double pay_tuition, HttpSession session){
		if(!(session.getAttribute("user") instanceof Student)){
			return "redirect:/login";
		}
		Student stew = (Student) session.getAttribute("user");
		double tuition_due = stew.getTuition();
		if(tuition_due-pay_tuition<= 0){
			stew.setTuition(0);
		}else{
			stew.setTuition(tuition_due-pay_tuition);
		}
		stu.getStudentService().updateStudent(stew);
    	return "redirect:/student";
    }
	
	@GetMapping("/changestudentpassword")
	public String changestudentpassword(Model model) 
	{
		return "changestudentpassword";
	}
	
	@RequestMapping("/changestudentpassword")
    public String changestudentpassword(Model model, @RequestParam("old_password") String oldpassword, 
    		@RequestParam("new_password") String newpassword, 
    		@RequestParam("confirm_new_password") String confirmnewpassword, HttpSession session){
		Student s = (Student) session.getAttribute("user");
		if(s.getPassword().equals(oldpassword) && newpassword.equals(confirmnewpassword)){
			s.setPassword(newpassword);
			stu.getStudentService().updateStudent(s);
		}
    	return "redirect:/student";
    }
	
	
	
    

}
