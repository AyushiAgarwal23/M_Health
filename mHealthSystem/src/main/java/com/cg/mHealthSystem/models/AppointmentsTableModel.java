package com.cg.mHealthSystem.models;

import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class AppointmentsTableModel {
	public Integer doctorId;
	public Integer patientId;
	public Integer appointmentId;
    @Pattern(regexp="^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$",message="Enter date in hh:mm format")
	public String startTime;
    @Pattern(regexp="^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$",message="Enter date in hh:mm format")
	public String endTime;
	public String createdAt;
	public String deletedAt;
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
	public Integer getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
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
	public AppointmentsTableModel(Integer doctorId, Integer patientId, Integer appointmentId, String startTime,
			String endTime, String createdAt, String deletedAt) {
		super();
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
	}
	public AppointmentsTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
