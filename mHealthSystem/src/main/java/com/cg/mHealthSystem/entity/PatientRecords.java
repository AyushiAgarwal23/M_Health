package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecords {
	@Id
	public int recordId;
	public int patientId;
	public int appointmentId;
	public String prescription ;
	public String healthComplication ;
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
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
	public PatientRecords(int recordId, int patientId, int appointmentId, String prescription,
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
