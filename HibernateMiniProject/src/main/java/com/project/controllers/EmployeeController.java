package com.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.models.Employee;
import com.project.service.IEmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	private String message;

	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView view=new ModelAndView();
		view.setViewName("menu");
		return view;
	}

	@RequestMapping("/registerpage")
	public ModelAndView displayRegisterPage(Model model) {
		model.addAttribute("employee",new Employee());

		ModelAndView view=new ModelAndView(); 
		view.setViewName("registerPage");

		return view;
	}
	
	@RequestMapping(value="/saveEmp",method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee,Model model) {
		
		Integer id=service.saveEmployee(employee);
		model.addAttribute("message","Employee "+id+" Saved..");
		model.addAttribute("employee",new Employee());
		ModelAndView view=new ModelAndView();
		view.setViewName("registerPage");
		
		return view;
	}
	
	@RequestMapping("/showAllEmp")
	public ModelAndView getAllEmployees(Model model) {
		List<Employee> employees=service.getAllEmployees();
		model.addAttribute("employees", employees);
		
		ModelAndView view=new ModelAndView();
		model.addAttribute("result", message);
		view.setViewName("employeeData");
		
		return view;
	}
	
	@RequestMapping("/removeEmp")
	public ModelAndView removeEmployee(@RequestParam("id")Integer id,Model model) {
		service.deleteEmployee(id);
		message="Succecfulley Employee Removed From DataBase..";
		model.addAttribute("result",message);
		
		ModelAndView view=new ModelAndView();
		view.setViewName("redirect:showAllEmp");
		return view;
	}
    @RequestMapping("/editEmp")
	public ModelAndView editPageShow(@RequestParam("id")Integer id,Model model) {
		Employee employee=service.getOneEmployee(id);
		model.addAttribute("employee",employee);
		ModelAndView view=new ModelAndView();
		view.setViewName("employeeEdit");
	
		return view;
	}
    
    @RequestMapping("/updateEmp")
    public ModelAndView updateEmployee(@ModelAttribute Employee employee,Model model) {
    	service.updateEmployee(employee);
    	message="Employee "+employee.getEmpId()+" Updated..";
    	model.addAttribute("message", message);
    		
    	ModelAndView view=new ModelAndView();
    	view.setViewName("redirect:showAllEmp");
    	return view;
    }

}
