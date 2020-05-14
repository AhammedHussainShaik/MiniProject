package com.project.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.project.dao.IEmployeeDAO;
import com.project.models.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public Integer saveEmployee(Employee employee) {
		
		return (Integer) hibernateTemplate.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		hibernateTemplate.update(employee);

	}

	@Override
	public void deleteEmployee(Integer id) {
		hibernateTemplate.delete(new Employee(id));

	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(Employee.class);
	}

}
