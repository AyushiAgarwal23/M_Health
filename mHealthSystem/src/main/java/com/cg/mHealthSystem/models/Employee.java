package com.cg.mHealthSystem.models;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	private Integer empId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String phoneNo;
	private String gender;
	private String dob;
	private String street;
	private String city;
	private String state;
	private String pinCode;
	private String idProof;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstname) {
		this.firstName = firstname;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public Employee(Integer empId, String firstName, String lastName, String middleName, String phoneNo, String gender,
			String dob, String street, String city, String state, String pinCode, String idProof) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNo = phoneNo;
		this.gender = gender;
		this.dob = dob;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.idProof = idProof;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		

}
