package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/helloWorld")
	public String helloWorld(Model model)
	{
		model.addAttribute("firstName", "Elizabeth");
		return "hello";
	}

}
