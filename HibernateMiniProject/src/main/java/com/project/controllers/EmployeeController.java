package com.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.models.Employee;
import com.project.service.IEmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeService service;

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
	
	@RequestMapping("/saveEmp")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee,Model model) {
		
		Integer id=service.saveEmployee(employee);
		model.addAttribute("message","Employee "+id+" Saved..");
		model.addAttribute("employee",new Employee());
		ModelAndView view=new ModelAndView();
		view.setViewName("registerPage");
		
		return view;
	}


}
