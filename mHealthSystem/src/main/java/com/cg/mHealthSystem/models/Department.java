
package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component

public class Department {
	private Integer deptId;
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	@NotNull
	private String deptName;
	@NotNull
	@Size(min =10,max =10)
	private String phoneNo;
	@NotNull
	@Pattern(regexp="\"^[A-Za-z_][a-zA-Z0-9+_.-]+[@][a-zA-Z]+[.][a-zA-Z]+$\"")
	private String emailId;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	

}