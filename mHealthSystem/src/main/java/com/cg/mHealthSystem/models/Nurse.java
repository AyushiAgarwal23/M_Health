package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;

@Component

public class Nurse {
	private Integer nurseId;
	private Integer deptId;
	private Integer userId;
	private Integer empId;
	private Integer nurseFee;
	
	public Integer getNurseFee() {
		return nurseFee;
	}
	public void setNurseFee(Integer nurseFee) {
		this.nurseFee = nurseFee;
	}
	public Integer getNurseId() {
		return nurseId;
	}
	public void setNurseId(Integer nurseId) {
		this.nurseId = nurseId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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
	
	

}
