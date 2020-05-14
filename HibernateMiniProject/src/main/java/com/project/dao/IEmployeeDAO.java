package com.project.dao;

import java.util.List;

import com.project.models.Employee;

public interface IEmployeeDAO {
	public Integer saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer id);
	public List<Employee> getAllEmployees();

}
