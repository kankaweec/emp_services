package com.th.employee.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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
import com.th.employee.utils.Utils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

//mark class as Controller
@RestController
@RequestMapping("/api/employees")
public class EmployeeController 
{
	//autowire the BooksService class
	@Autowired
	EmployeeService employeeService;
	
	//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/getEmployee")
	@ApiOperation(value="Find all employees", authorizations = { @Authorization (value="jwtToken") },notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private List<Employee> getAllBooks() {
		return employeeService.getAllEmployee();
	}
	
	//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/getEmployee/{emp_id}")
	@ApiOperation(value="Find employees by id",notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private Employee getBooks(@PathVariable("emp_id") int emp_id) {
		return employeeService.getEmployeeById(emp_id);
	}
	
	//creating a delete mapping that deletes a specified book
	@DeleteMapping("/deleteEmploy/{emp_id}")
	@ApiOperation(value="Delete employees by id", authorizations = { @Authorization (value="jwtToken") },notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private void deleteBook(@PathVariable("emp_id") int emp_id) {
		employeeService.delete(emp_id);	
	}
	
	//creating post mapping that post the book detail in the database
	@PostMapping("/addNewEmployee")
	@ApiOperation(value="Add new employees by id", authorizations = { @Authorization (value="jwtToken") },notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private String saveBook(@RequestBody Employee employee) {		
		employee.setEmp_id(Utils.getDate("yyyyMMdd")+String.format("%04d", employee.getSeq_id()));		
		employee.setMember_type(Utils.getMemberType(employee.getSalary()));
		employeeService.saveOrUpdate(employee);
		return employee.getEmp_id();
	}
	
	//creating put mapping that updates the book detail 
	@PutMapping("/updateEmployee")
	@ApiOperation(value="Update employees by id", authorizations = { @Authorization (value="jwtToken") },notes="Provide an id to get employee information",response=Employee.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved an employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	private Employee update(@RequestBody Employee employee) {
		employee.setMember_type(Utils.getMemberType(employee.getSalary()));
		employeeService.saveOrUpdate(employee);
		return employee;
	}
}
