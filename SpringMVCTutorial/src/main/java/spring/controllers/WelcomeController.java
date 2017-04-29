package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



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

	
    public String redirect()
    {
        /* your logic here */
        return "redirect:newPage";
    }

	public String newPage()
	{
		return "";
	}
}
