package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
	public int doctorId;
	public  int userId;
	public int empId;
	public int deptId;
	public int consultingFee;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
	public int getConsultingFee() {
		return consultingFee;
	}
	public void setConsultingFee(int consultingFee) {
		this.consultingFee = consultingFee;
	}
	public Doctor(int doctorId, int userId, int empId, int deptId, int consultingFee) {
		super();
		this.doctorId = doctorId;
		this.userId = userId;
		this.empId = empId;
		this.deptId = deptId;
		this.consultingFee = consultingFee;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
