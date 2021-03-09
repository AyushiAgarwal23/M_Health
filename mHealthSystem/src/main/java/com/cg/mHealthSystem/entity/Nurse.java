package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Nurse {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer nurseId;
 private Integer userId;
 private Integer empId;
 private Integer deptId;
 private Integer nurseFee;
public Integer getNurseId() {
	return nurseId;
}
public void setNurseId(Integer nurseId) {
	this.nurseId = nurseId;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public Integer getEmpId() {
	return empId;
}
public void setEmpId(Integer empId) {
	this.empId = empId;
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
public Nurse(Integer nurseId, Integer userId, Integer empId, Integer deptId, Integer nurseFee) {
	super();
	this.nurseId = nurseId;
	this.userId = userId;
	this.empId = empId;
	this.deptId = deptId;
	this.nurseFee = nurseFee;
}
public Nurse() {
	super();
	// TODO Auto-generated constructor stub
}


 
 
}
