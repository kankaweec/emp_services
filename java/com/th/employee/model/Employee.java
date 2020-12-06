package com.th.employee.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Employee detail")
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Employee
{
	
	@ApiModelProperty(notes="Employee id")
	//Defining book id as primary key
	@Id
	@Column
	private String emp_id;
	@ApiModelProperty(notes="Employee name")
	@Column
	private String emp_name;
	@ApiModelProperty(notes="Salary")
	@Column
	private String salary;
	@ApiModelProperty(notes="Member Type")
	@Column
	private String member_type;
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
}