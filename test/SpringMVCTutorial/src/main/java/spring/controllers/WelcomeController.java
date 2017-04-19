package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WelcomeController 
{
	@GetMapping("/welcome")
	public String welcome(Model model) 
	{
		model.addAttribute("firstName", "Dmitriy");
		model.addAttribute("name", "Tarasov");
		return "welcomeMessage";
	}
	//@getMapping("/redirect")
    public String redirect()
    {
        /* your logic here */
        return "redirect:newPage";
    }
	//@getMapping("/hello")
	public String newPage()
	{
		return "";
	}
}
