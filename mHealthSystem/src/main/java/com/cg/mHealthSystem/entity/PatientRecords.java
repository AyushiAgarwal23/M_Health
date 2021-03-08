package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecords {
	@Id
	private Integer recordId;
	private Integer patientId;
	private Integer appointmentId;
	private String prescription ;
	private String healthComplication ;
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getHealthComplication() {
		return healthComplication;
	}
	public void setHealthComplication(String healthComplication) {
		this.healthComplication = healthComplication;
	}
	public PatientRecords(Integer recordId, Integer patientId, Integer appointmentId, String prescription,
			String healthComplication) {
		super();
		this.recordId = recordId;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
		this.prescription = prescription;
		this.healthComplication = healthComplication;
	}
	public PatientRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
