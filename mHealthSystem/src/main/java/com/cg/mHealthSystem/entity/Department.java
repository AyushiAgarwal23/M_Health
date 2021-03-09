package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	private Integer deptId;
	private String deptName;
	private String phoneNo;
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
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
