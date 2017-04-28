package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import spring.model.Report;


@Controller //("/TeacherReport")
public class TeacherReportController 
{
	@GetMapping("/teacherreport")
	//@RequestMapping(value = "/teacherreport", method = RequestMethod.GET)
	public String teacherreport(Model model) 
	{

		model.addAttribute("name", "hi");
		model.addAttribute("firstName", "y");
		return "teacherreport";
	}
//    @RequestMapping(value = "/report", method = RequestMethod.GET)
//    public String report(Model model) {
//        model.addAttribute("msg", "Please Enter Your Login Details");
//        return "report";
//    }
// 
	@RequestMapping("/teacherreport")
	//@RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("TeacherReport") Report reportBean) {
    	//String type="";
		model.addAttribute("msg", "welcome, " + reportBean.getReport());
		model.addAttribute("msg", "welcome, " + reportBean.getName());
    	return "redirect:login";
    }

}