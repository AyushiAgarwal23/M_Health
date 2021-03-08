package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nurse {
 @Id
 public int nurseId;
 public int userId;
 public int empId;
 public int deptId;
 public int nurseFee;
public int getNurseId() {
	return nurseId;
}
public void setNurseId(int nurseId) {
	this.nurseId = nurseId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public int getNurseFee() {
	return nurseFee;
}
public void setNurseFee(int nurseFee) {
	this.nurseFee = nurseFee;
}
public Nurse(int nurseId, int userId, int empId, int deptId, int nurseFee) {
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
