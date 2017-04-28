package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import spring.model.Report;


@Controller("/StudentReport")
public class StudentReportController 
{
	@GetMapping("studentreport")
	//@RequestMapping(value = "/studentreport", method = RequestMethod.GET)
	public String studentreport(Model model) 
	{

		model.addAttribute("name", "hi");
		model.addAttribute("firstName", "y");
		return "studentreport";
	}
//    @RequestMapping(value = "/report", method = RequestMethod.GET)
//    public String report(Model model) {
//        model.addAttribute("msg", "Please Enter Your Login Details");
//        return "report";
//    }
// 
	@RequestMapping("studentreport")
	//@RequestMapping(value = "/test", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("StudentReport") Report reportBean) {
    	//String type="";
		model.addAttribute("msg", "welcome, " + reportBean.getReport());
		model.addAttribute("msg", "welcome, " + reportBean.getName());
		model.addAttribute("msg", "welcome, " + reportBean.getGrade());
    	return "redirect:login";
    }

}