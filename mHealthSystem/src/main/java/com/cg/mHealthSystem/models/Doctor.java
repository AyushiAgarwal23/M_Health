package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;

import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Employee;

@Component

public class Doctor {
	
	 private Integer doctorId;
	 private Appointments appointments;
	 private Department department;
	 private Employee employee ;
	 private Integer consultingFee;
	 
	 
	
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public Appointments getAppointments() {
		return appointments;
	}
	public void setAppointments(Appointments appointments) {
		this.appointments = appointments;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Integer getConsultingFee() {
		return consultingFee;
	}
	public void setConsultingFee(Integer consultingFee) {
		this.consultingFee = consultingFee;
	}
	  
	public Doctor(Integer doctorId, Appointments appointments, Department department, Employee employee,
			Integer consultingFee) {
		super();
		this.doctorId = doctorId;
		this.appointments = appointments;
		this.department = department;
		this.employee = employee;
		this.consultingFee = consultingFee;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
