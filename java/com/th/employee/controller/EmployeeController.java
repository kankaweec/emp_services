package com.th.employee.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.th.employee.model.Employee;
import com.th.employee.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getEmployee")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/getEmployee/{emp_id}")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private Employee getEmployee(@PathVariable("emp_id") int emp_id) {
		return employeeService.getEmployeeById(emp_id);
	}
	
	@DeleteMapping("/deleteEmployee/{emp_id}")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private void deleteEmployee(@PathVariable("emp_id") int emp_id) {
		employeeService.delete(emp_id);
	}
	
	@PostMapping("/saveEmployee")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private String saveEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee.getEmp_id();
	}
	
	@PutMapping("/updateEmployee")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private Employee update(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee;
	}
}
