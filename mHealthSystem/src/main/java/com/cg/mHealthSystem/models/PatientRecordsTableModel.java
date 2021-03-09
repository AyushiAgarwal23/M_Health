package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;
@Component

public class PatientRecordsTableModel {
	public Integer recordId;
	public Integer patientId;
	
	public String healthComplication;
	public String prescription;
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
	
	public String getHealthComplication() {
		return healthComplication;
	}
	public void setHealthComplication(String healthComplication) {
		this.healthComplication = healthComplication;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public PatientRecordsTableModel(Integer recordId, Integer patientId, Integer appointmentId,
			String healthComplication, String prescription) {
		super();
		this.recordId = recordId;
		this.patientId = patientId;
		this.appointmentId = appointmentId;
		this.healthComplication = healthComplication;
		this.prescription = prescription;
	}
	public PatientRecordsTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
