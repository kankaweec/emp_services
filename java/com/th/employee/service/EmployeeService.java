package com.th.employee.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.employee.model.Employee;
import com.th.employee.repository.EmployeeRepository;



//defining the business logic
@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	//getting all books record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployee() 
	{
		List<Employee> employee = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(books1 -> employee.add(books1));
		return employee;
	}
	
	//getting a specific record by using the method findById() of CrudRepository
	public Employee getEmployeeById(int id) 
	{
		return employeeRepository.findById(id).get();
	}
	
	//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	
	//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) 
	{
		employeeRepository.deleteById(id);
	}
	
	//updating a record
	public void update(Employee employee, int bookid) 
	{
		employeeRepository.save(employee);
	}
}