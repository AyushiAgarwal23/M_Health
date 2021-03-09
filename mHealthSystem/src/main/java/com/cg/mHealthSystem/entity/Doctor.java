package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    private Integer doctorId;
    private  Integer userId;
    private Integer empId;
    private Integer deptId;
    private Integer consultingFee;
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
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
	public Integer getConsultingFee() {
		return consultingFee;
	}
	public void setConsultingFee(Integer consultingFee) {
		this.consultingFee = consultingFee;
	}
	public Doctor(Integer doctorId, Integer userId, Integer empId, Integer deptId, Integer consultingFee) {
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
