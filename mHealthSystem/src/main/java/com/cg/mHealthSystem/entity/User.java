package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Table123")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String firstName;
	@Pattern(regexp="\"^[A-Za-z_][a-zA-Z0-9+_.-]+[@][a-zA-Z]+[.][a-zA-Z]+$\"")
	private String emailId;
	
	private String password;
	
	@OneToOne
	@JoinColumn(name ="roleId")
	private Roles role;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public User(Integer userId, String firstName, String emailId, String password) {
		super();
		this.userId = userId;
		
		this.firstName = firstName;
		this.emailId = emailId;
		this.password = password;
	}
	public User() {
		super();
	}
	
	
	
}
