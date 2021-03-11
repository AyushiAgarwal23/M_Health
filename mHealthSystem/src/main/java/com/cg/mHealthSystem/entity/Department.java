package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deptId;
	@NotNull
	private String deptName;
	@NotNull
	@Size(min =10,max =10)
	private String phoneNo;
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String emailId;
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
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
	public Department(Integer deptId, String deptName, String phoneNo, String emailId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}
	public Department() {
		super();
	}
	
	
	
	
}
