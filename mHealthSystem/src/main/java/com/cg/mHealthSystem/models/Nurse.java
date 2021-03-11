package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;

import com.cg.mHealthSystem.entity.Employee;

@Component

public class Nurse {
	private Integer nurseId;
	private Integer userId;
	private Employee employee;
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	public Nurse() {
		super();

	}
	

	
	

}
