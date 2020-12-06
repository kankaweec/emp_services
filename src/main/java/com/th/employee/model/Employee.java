package com.th.employee.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Employee Detail")
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Employee
{	
	@ApiModelProperty(notes="Sequence id")
	@Id
	@Column
	private int seq_id;
	@ApiModelProperty(notes="Employee id")
	@Column
	private String emp_id;
	@ApiModelProperty(notes="Employee name")
	@Column
	private String emp_name;
	@ApiModelProperty(notes="Salary")
	@Column
	private double salary;
	@ApiModelProperty(notes="Member Type")
	@Column
	private String member_type;
	
	public int getSeq_id() {
		return seq_id;
	}
	public void setSeq_id(int seq_id) {
		this.seq_id = seq_id;
	}
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}

	
}