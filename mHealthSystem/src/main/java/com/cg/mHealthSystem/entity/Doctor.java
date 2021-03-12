package com.cg.mHealthSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author ayushranjan
 *
 *This is Entity class for Doctor Table
 */
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer doctorId;
   
    
    @OneToOne(cascade = CascadeType.ALL)
   	@JoinColumn(name ="empId")
    private Employee employee ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "appointmentId")
    private Appointments appointments;
    
   
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="deptId")
    private Department department ;
    @NotNull
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

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	
	public Integer getConsultingFee() {
		return consultingFee;
	}
	public void setConsultingFee(Integer consultingFee) {
		this.consultingFee = consultingFee;
	}
	
	public Doctor() {
		super();
		
	}

	public Doctor(Integer doctorId, Employee employee, Appointments appointments, Department department,
			Integer consultingFee) {
		super();
		this.doctorId = doctorId;
		this.employee = employee;
		this.appointments = appointments;
		this.department = department;
		this.consultingFee = consultingFee;
	}
	
	
	
	
}
