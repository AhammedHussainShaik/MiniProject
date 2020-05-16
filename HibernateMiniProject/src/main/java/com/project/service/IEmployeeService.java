package com.project.service;

import java.util.List;

import com.project.models.Employee;

public interface IEmployeeService {
	public Integer saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer id);
	public List<Employee> getAllEmployees();
	public Employee getOneEmployee(Integer id);

}
