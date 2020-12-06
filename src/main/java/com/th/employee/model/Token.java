package com.th.employee.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Token for authen")
//mark class as an Entity 
@Entity
//defining class name as Table name
@Table
public class Token {

	@ApiModelProperty(notes="Employee id")
	@Id
	@Column
	private String empid;
    @ApiModelProperty(notes="Token")
    @Column
    private String token;
    
    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
}