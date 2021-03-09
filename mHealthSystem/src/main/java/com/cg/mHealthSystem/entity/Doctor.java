package com.cg.mHealthSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Doctor {
    @Id
    private Integer doctorId;
    
   // private  Integer userId;
    //private Integer empId;
    
    @OneToOne
   	@JoinColumn(name ="empId")
    private Employee employee ;
    
    @OneToOne
   	@JoinColumn(name ="userId")
    private User user ;
   // private Integer deptId;
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="deptId")
    private Department department ;
    private Integer consultingFee;
	public Integer getDoctorId() {
		return doctorId;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	/*public Integer getUserId() {
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
	}*/
	public Integer getConsultingFee() {
		return consultingFee;
	}
	public void setConsultingFee(Integer consultingFee) {
		this.consultingFee = consultingFee;
	}
	/*public Doctor(Integer doctorId, Integer userId, Integer empId, Integer deptId, Integer consultingFee) {
		super();
		this.doctorId = doctorId;
	this.userId = userId;
		this.empId = empId;
		this.deptId = deptId;
		this.consultingFee = consultingFee;
	}*/
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(Integer doctorId, Employee employee, User user, Department department, Integer consultingFee) {
		super();
		this.doctorId = doctorId;
		this.employee = employee;
		this.user = user;
		this.department = department;
		this.consultingFee = consultingFee;
	}
	
	
	
	
}
