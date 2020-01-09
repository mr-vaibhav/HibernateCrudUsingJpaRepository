package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Benefits;
import com.example.model.Employee;
import com.example.service.BenefitsService;
import com.example.service.EmployeeService;

@RestController 
public class EmployeeController implements ErrorController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	private static final String PATH = "/error";
	ModelAndView model = new ModelAndView();

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	BenefitsService benefitsService;

	@PostMapping(value = "/employeeEntry")
	public ModelAndView employeeEntry(@ModelAttribute("employee") Employee employee,BindingResult result) {// @RequestBody  Employee employee @ModelAttribute("employee") Employee employee
		logger.info("Spring params is welcome");
		logger.info("The First Name Is" + employee.getFirstName());
		//logger.info("The First Name Is" + employee.getAccount().getAccountNumber());
		employeeService.createEmployee(employee);
		model.setViewName("Success");
		return model;
	}

	
	@GetMapping(value = "/employeeList")
	public ModelAndView employeeList() {
		 List<Employee> listEmployee = employeeService.employeeList();
		return new ModelAndView("list","listEmployee",listEmployee);
	}
		
	@RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView Signup() {
		logger.info(" In controller with Sign up");
		List<Benefits> listBenefits = benefitsService.benefitsList();
		return new ModelAndView("form","listBenefits",listBenefits);
    }
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editEmployee() {
		logger.info(" In controller with edit");
        return new ModelAndView("edit");
    }
	

	@RequestMapping(value="/delete/{employeeId}",method =RequestMethod.GET)
	public String deleteStudentById(@PathVariable(value = "employeeId") Integer id) {
		logger.info("Spring delete....................Emp");
		employeeService.deleteEmployeeById(id);
		return "Student has been deleted with id"+" "+id;
	}
	
	@RequestMapping(value = PATH, method = RequestMethod.GET)
	public ModelAndView defaultErrorMessage() {
		model.setViewName("error");
		return model;
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
	
	@RequestMapping(value = "/editEmployee/{employeeId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("employeeId") Integer id) {
		logger.info("Inside Find Emp By Id....................Emp");
	  ModelAndView model = new ModelAndView("edit");
        Employee employee = employeeService.findEmployeeById(id);
        model.addObject("employee", employee);
        return model;
    }
	
	@RequestMapping(value = "/editEmployee/update", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute("employee") Employee employee) {
		logger.info("Inside Udate Emp by Id....................Emp");
        Employee user = employeeService.findEmployeeById(employee.getEmployeeId());
        user.setFirstName(employee.getFirstName());
        user.setLastName(employee.getLastName());
        user.setEmailId(employee.getEmailId());
        user.setMobileNumber(employee.getMobileNumber());
        user.setSalary(employee.getSalary());
        employeeService.createEmployee(user);
        return new ModelAndView("redirect:/employeeList");
    }

}
