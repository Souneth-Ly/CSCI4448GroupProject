package spring.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.database.DatabaseCaller;
import spring.model.AbstractUser;
import spring.model.Teacher;
import spring.model.Dean;
import spring.model.Student;


@Controller


public class LoginController {
    
    
	@Autowired
	DatabaseCaller stu;
    
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, AbstractUser absuser) {
    	String type="login";
    	
    	//checks if user exists
    	if(stu.getStudentService().findByUserName(absuser.getUserName())!=null){
    		Student stew = (Student) stu.getStudentService().findByUserName(absuser.getUserName());
    		//checks if input password matches password
    		if(stew.getPassword().equals(absuser.getPassword())){
    			model.addAttribute("msg", "welcome, " + stew.getName() + " you are a: " + stew.getType());
    			type=stew.getType();
    		}
    		model.addAttribute("error", "Password does not match username");
    	}
    	//checks if user exists
    	else if(stu.getTeacherService().findByUserName(absuser.getUserName())!=null){
    		Teacher teach = (Teacher) stu.getTeacherService().findByUserName(absuser.getUserName());
    		//checks if input password matches password
    		if(teach.getPassword().equals(absuser.getPassword())){
    			model.addAttribute("msg", "welcome, " + teach.getName() + " you are a: " + teach.getType());
    			type=teach.getType();
    		}
    		model.addAttribute("error", "Password does not match username");
    	}
    	//checks if user exists
    	else if(stu.getDeanService().findByUserName(absuser.getUserName())!=null){
    		Dean dean = (Dean) stu.getDeanService().getDean();
    		//checks if input password matches password
    		if(dean.getPassword().equals(absuser.getPassword())){
    			model.addAttribute("msg", "welcome, " + dean.getName() + " you are a: " + dean.getType());
    			type=dean.getType();
    		}
    		model.addAttribute("error", "Password does not match username");
    	}else{
    		model.addAttribute("error", "Details don't match anyone");
    	}
		return type;
    }
}
