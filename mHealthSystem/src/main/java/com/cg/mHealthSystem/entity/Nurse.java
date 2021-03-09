package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Nurse {
 @Id
 private Integer nurseId;
 
 @OneToOne
 @JoinColumn(name="userId")
 private User user;
   
 @OneToOne
 @JoinColumn(name ="empId")
 private Employee employee ;
 //private Integer empId;
 private Integer deptId;
 private Integer nurseFee;
public Integer getNurseId() {
	return nurseId;
}
public void setNurseId(Integer nurseId) {
	this.nurseId = nurseId;
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}

public Integer getDeptId() {
	return deptId;
}
public void setDeptId(Integer deptId) {
	this.deptId = deptId;
}
public Integer getNurseFee() {
	return nurseFee;
}
public void setNurseFee(Integer nurseFee) {
	this.nurseFee = nurseFee;
}

public Nurse(Integer nurseId, User user, Employee employee, Integer deptId, Integer nurseFee) {
	super();
	this.nurseId = nurseId;
	this.user = user;
	this.employee = employee;
	this.deptId = deptId;
	this.nurseFee = nurseFee;
}
public Nurse() {
	super();
	// TODO Auto-generated constructor stub
}


 
 
}
