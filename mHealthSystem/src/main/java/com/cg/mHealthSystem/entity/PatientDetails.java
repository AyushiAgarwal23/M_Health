package com.cg.mHealthSystem.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

public class PatientDetails {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;
	@Column
	private Integer userId;
	@Column
	private Integer recordId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String middleName;
	@Column
	private String phoneNo;
	@Column
	private String gender;
	@Column
	private String dateOfBirth;
	@Column
	private String street;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String pincode;
	@Column
	private String idProof;
	@OneToOne
	public PatientRecords patientrecords;
	@OneToOne(cascade=CascadeType.ALL)
	public Appointments appointment ;
	
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
	public PatientRecords getPatientrecords() {
		return patientrecords;
	}
	public void setPatientrecords(PatientRecords patientrecords) {
		this.patientrecords = patientrecords;
	}
	public Appointments getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointments appointment) {
		this.appointment = appointment;
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
	public PatientDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PatientDetails(Integer patientId, Integer userId, Integer recordId, String firstName,
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
	
	
}
	