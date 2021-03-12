package com.cg.mHealthSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author ayushranjan
 *
 *This is Entity class for PatientRecords Table
 */
@Entity
@Table(name="Records")
public class PatientRecords {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recordId;
	public Integer patientId;	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	private String prescription ;
	private String healthComplication ;
	
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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
	
	public PatientRecords(Integer recordId, Integer patientId, String prescription, String healthComplication) {
		super();
		this.recordId = recordId;
		this.patientId = patientId;
		this.prescription = prescription;
		this.healthComplication = healthComplication;
	}
	public PatientRecords() {
		super();

	}

}
