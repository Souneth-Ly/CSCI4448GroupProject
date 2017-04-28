package spring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;


import spring.model.Student;



@Controller("/student")
public class StudentController {
    

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String student(Model model, HttpSession session) 
	{
		Student s = (Student) session.getAttribute("user");
		model.addAttribute("name", s.getName());
		model.addAttribute("username", s.getUserName());
		model.addAttribute("password", s.getPassword());
		
		return "student";
	}
	
    

}
