package spring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.AbstractUser;
import spring.model.Teacher;
import spring.model.Dean;
import spring.model.Student;
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "login";
    }
 
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("AbstractUser") LoginBean loginBean) {
        //System.out.print(loginBean.login()[0]);
        //System.out.print(loginBean.login()[1]);
    	String type="";
    	AbstractUser user=null;
    	
    	// put this into database or somewhere else --------------------
    	AbstractUser defaultUser=new Dean();
    	AbstractUser[] users={defaultUser}; 
    	//--------------------------------------------------------------
    	
    	for(int i=0;i<=users.length-1;i++) { 
    		if (loginBean.getUserName().equals(users[i].getUserName()) 
    				&& loginBean.getPassword().equals(users[i].getPassword())) { 
    			//passwords shouldn't be stored here
    			user=users[i];
    			break;
    		} 
    	}
    	if(user instanceof Teacher){
    		Teacher ATeacher=(Teacher) user;
    		model.addAttribute("msg", "welcome, Instructor" + user.getName());
    		type=ATeacher.getType();
    	}
    	else if(user instanceof Student){
    		Student AStudent=(Student) user;
    		model.addAttribute("msg", "welcome, " + user.getName());
    		type=AStudent.getType();
    	}
    	else if(user instanceof Dean){
    		Dean ADean=(Dean) user;
    		model.addAttribute("msg", "welcome, Dean " + user.getName());
    		type=ADean.getType();
    	}
    	else{
    		//System.out.print("void entries");
    		model.addAttribute("error", "Details don't match anyone");
    		type="login";
    	}
    	return type;
    }
}
