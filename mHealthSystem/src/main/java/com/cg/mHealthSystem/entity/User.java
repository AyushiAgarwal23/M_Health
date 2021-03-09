package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	private Integer userId;
	private Integer roleId;
	private String firstName;
	private String emailId;
	private String password;
	@OneToOne
	private Doctor doctor ;
	@OneToOne
	private Roles role;
	@OneToOne
	private Nurse nurse ;
	@OneToOne
	private PatientDetails patientdetails;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(Integer userId, Integer roleId, String firstName, String emailId, String password) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.firstName = firstName;
		this.emailId = emailId;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
