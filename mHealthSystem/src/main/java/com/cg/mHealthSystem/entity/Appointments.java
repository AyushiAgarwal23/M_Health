package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author ayushranjan
 *
 *This is Entity class for Appointment Table
 */

@Entity
public class Appointments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer appointmentId;
	private Integer doctorId;
	private Integer patientId;
	private String startTime;
	private String endTime;
	private String createdAt;
	private String deletedAt;
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	public Appointments(int appointmentId, int doctorId, int patientId, String startTime, String endTime,
			String createdAt, String deletedAt) {
		super();
		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
	}
	public Appointments() {
		super();

	}

	
	
	

}
