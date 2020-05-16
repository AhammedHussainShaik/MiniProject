package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.IEmployeeDAO;
import com.project.models.Employee;
import com.project.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO employeeDao;


	@Transactional
	public Integer saveEmployee(Employee employee) {
		//Do Calculation here
		return employeeDao.saveEmployee(employee);
	}


	@Transactional
	public void updateEmployee(Employee employee) {
		//Do Calculation here
		employeeDao.updateEmployee(employee);

	}


	@Transactional
	public void deleteEmployee(Integer id) {
		// Do Calculation here
		employeeDao.deleteEmployee(id);

	}


	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		// Do Calculation here
		return employeeDao.getAllEmployees();
	}


	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		//Do Calculation here
		return employeeDao.getOneEmployee(id);
	}

}
