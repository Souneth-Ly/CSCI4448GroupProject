package spring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;


import spring.model.Dean;



@Controller("/dean")
public class DeanController {
    
	//@GetMapping("/dean")
	@RequestMapping(value = "/dean", method = RequestMethod.GET)
	public String dean(Model model, HttpSession session) 
	{
		Dean d = (Dean) session.getAttribute("user");
		model.addAttribute("name", d.getName());
		model.addAttribute("username", d.getUserName());
		model.addAttribute("password", d.getPassword());
		return "dean";
	}
	
    

}
