package spring.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Student;
import spring.service.StudentService;


@Controller
@RequestMapping("/")
@ComponentScan("spring") 
public class AppController {
	
    @Autowired
    StudentService service;
     
    @Autowired
    MessageSource messageSource;
     
     // This method will list all existing Students.    
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listStudents(ModelMap model) {
 
        List Students = service.findAllStudents();
        model.addAttribute("Students", Students);
        return "allStudents";
    }
     
    // This method will provide the medium to add a new Student.     
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newStudent(ModelMap model) {
        Student Student = new Student();
        model.addAttribute("Student", Student);
        model.addAttribute("edit", false);
        return "registration";
    }
     
     // This method will be called on form submission, handling POST request for
     // saving Student in database. It also validates the user input     
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveStudent(@Valid Student Student, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
         
         // Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         // and applying it on field [ssn] of Model class [Student].Below mentioned peace of code [if block] is 
          // to demonstrate that you can fill custom errors outside the validation
         // framework as well while still using internationalized messages.
          
      
//        if(!service.isStudentSsnUnique(Student.getId(), Student.getSsn())){
//            FieldError ssnError =new FieldError("Student","ssn",messageSource.getMessage("non.unique.ssn", new String[]{Student.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }
         
        service.saveStudent(Student);
 
        model.addAttribute("success", "Student " + Student.getId() + " registered successfully");
        return "success";
    }
     
//     // This method will provide the medium to update an existing Student.     
//    @RequestMapping(value = { "/edit-{ssn}-Student" }, method = RequestMethod.GET)
//    public String editStudent(@PathVariable String ssn, ModelMap model) {
//        Student Student = service.findStudentBySsn(ssn);
//        model.addAttribute("Student", Student);
//        model.addAttribute("edit", true);
//        return "registration";
//    }
     
   
     // This method will be called on form submission, handling POST request for
     // updating Student in database. It also validates the user input
    
    @RequestMapping(value = { "/edit-{ssn}-Student" }, method = RequestMethod.POST)
    public String updateStudent(@Valid Student Student, BindingResult result,
            ModelMap model, @PathVariable String ssn) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
//        if(!service.isStudentSsnUnique(Student.getId(), Student.getSsn())){
//            FieldError ssnError =new FieldError("Student","ssn",messageSource.getMessage("non.unique.ssn", new String[]{Student.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }
 
        service.updateStudent(Student);
 
        model.addAttribute("success", "Student " + Student.getId()  + " updated successfully");
        return "success";
    }
         
     // This method will delete an Student by it's SSN value.     
    @RequestMapping(value = { "/delete-{ssn}-Student" }, method = RequestMethod.GET)
    public String deleteStudent(@PathVariable String ssn) {
        service.deleteStudentBySsn(ssn);
        return "redirect:/list";
    }
 
}
