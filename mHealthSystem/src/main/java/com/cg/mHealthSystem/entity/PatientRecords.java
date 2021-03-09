package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientRecords {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recordId;
	private Integer patientId;
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
	public PatientRecords(Integer recordId, Integer patientId, String prescription,
			String healthComplication) {
		super();
		this.recordId = recordId;
		this.patientId = patientId;
		
		this.prescription = prescription;
		this.healthComplication = healthComplication;
	}
	public PatientRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
