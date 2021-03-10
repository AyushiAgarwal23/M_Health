package com.cg.mHealthSystem.models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Component
public class PatientDetailsTableModel {
	
	public Integer patientId;
	public Integer userId;
	public Integer recordId;
	public String firstName;
	public String lastName;
    public String middleName;
    public String phoneNo;
    public String gender;
    public String dateOfBirth;
    public String street;
    public String city;
    public String state;
    public String pincode;
    @NotNull
	@Size(min =12,max =12)
    public String idProof;
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public PatientDetailsTableModel(Integer patientId, Integer userId, Integer recordId, String firstName,
			String lastName, String middleName, String phoneNo, String gender, String dateOfBirth, String street,
			String city, String state, String pincode, String idProof) {
		super();
		this.patientId = patientId;
		this.userId = userId;
		this.recordId = recordId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.idProof = idProof;
	}
	public PatientDetailsTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	




}
