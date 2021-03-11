
package com.cg.mHealthSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Nurse {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer nurseId;
 private Integer userId;
 
 @OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name ="empId")
 private Employee employee;
 @NotNull
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

public Integer getNurseFee() {
	return nurseFee;
}
public void setNurseFee(Integer nurseFee) {
	this.nurseFee = nurseFee;
}

public Nurse(Integer nurseId, Integer userId, Employee employee, Integer nurseFee) {
	super();
	this.nurseId = nurseId;
	this.userId = userId;
	this.employee = employee;
	this.nurseFee = nurseFee;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Nurse() {
	super();

}


 
 
}

