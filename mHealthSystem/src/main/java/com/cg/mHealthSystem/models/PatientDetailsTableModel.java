
package com.cg.mHealthSystem.models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.PatientRecords;
@Component
public class PatientDetailsTableModel {
	
	public Integer patientId;
	public Integer userId;
	public Integer recordId;
	public String firstName;
	public String lastName;
    public String middleName;
    @Size(min =10,max =10)
    public String phoneNo;
    public String gender;
    @Pattern(regexp="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",message= "Enter valid date of birth in dd/mm/yyyy format")
    public String dateOfBirth;
    public String street;
    public String city;
    public String state;
    @Size(min =6,max =6)
    public String pincode;
    public PatientRecords patientrecords;
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
	public Appointments appointment ;
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
			String city, String state, String pincode, PatientRecords patientrecords, Appointments appointment,
			@NotNull @Size(min = 12, max = 12) String idProof) {
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
		this.patientrecords = patientrecords;
		this.appointment = appointment;
		this.idProof = idProof;
	}
	public PatientDetailsTableModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	




}

