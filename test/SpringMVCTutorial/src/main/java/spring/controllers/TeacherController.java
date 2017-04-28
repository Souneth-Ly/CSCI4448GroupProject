package spring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;


import spring.model.Teacher;



@Controller("/teacher")
public class TeacherController {
    
	//@GetMapping("/dean")
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String teacher(Model model, HttpSession session) 
	{
		Teacher t = (Teacher) session.getAttribute("user");
		model.addAttribute("name", t.getName());
		model.addAttribute("username", t.getUserName());
		model.addAttribute("password", t.getPassword());
		return "teacher";
	}
	
    

}
