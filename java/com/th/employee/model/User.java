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
public class User
{
	
	@ApiModelProperty(notes="Employee id")
	//Defining book id as primary key
	@Id
	@Column
	private String guid; 
	@ApiModelProperty(notes="Employee name")
	@Column
	private String user_name;
	@ApiModelProperty(notes="Salary")
	@Column
	private String password;
	@ApiModelProperty(notes="Member Type")
	@Column
	private String member_type;
	
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = java.util.UUID.randomUUID().toString();
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMember_type() {
		return member_type;
	}
	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}
}