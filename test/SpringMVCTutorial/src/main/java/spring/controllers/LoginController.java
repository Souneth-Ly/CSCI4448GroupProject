package spring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.AbstractUser;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("AbstractUser") AbstractUser loginBean) {
        if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {

            if (loginBean.getUserName().equals("hi1") && loginBean.getPassword().equals("hi123")) { //passwords shouldn't be stred here
                model.addAttribute("msg", "Welcome " + loginBean.getUserName());
                return "welcomeMessage";
            } else {
            	//System.out.print("void entries");
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
}
