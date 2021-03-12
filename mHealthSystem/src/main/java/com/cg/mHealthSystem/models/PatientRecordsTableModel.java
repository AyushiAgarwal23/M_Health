/** 	
    * @author Ayushi
    * 
    * 
    * This is the Class for Patient Records Entity
    */
package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;

import com.cg.mHealthSystem.entity.PatientDetails;
@Component

public class PatientRecordsTableModel {
	
	public Integer recordId;	
	public Integer patientId;	
	public String healthComplication;
	public String prescription;
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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
	
	public PatientRecordsTableModel(Integer recordId, Integer patientId, String healthComplication,
			String prescription) {
		super();
		this.recordId = recordId;
		this.patientId = patientId;
		this.healthComplication = healthComplication;
		this.prescription = prescription;
	}
	public PatientRecordsTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	}
	
	
