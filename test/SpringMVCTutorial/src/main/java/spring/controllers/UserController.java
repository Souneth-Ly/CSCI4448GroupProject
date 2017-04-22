package spring.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class UserController {
	@GetMapping("/user")
	public String user(Model model) 
	{
		model.addAttribute("name", "");
		model.addAttribute("email", "");
		model.addAttribute("username", "");
		model.addAttribute("password", "");
		return "userMessage";
	}
}
