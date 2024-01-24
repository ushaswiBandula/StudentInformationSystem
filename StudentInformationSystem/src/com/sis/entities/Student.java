package com.sis.entities;

import java.util.List;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String mobileNo;
	List<Enrollments> enrollments;
	public int getId() {
		return id;
	}
	public List<Enrollments> getEnrollments() {
		return enrollments;
	}
	public Student(int id, String firstName, String lastName, String dateOfBirth, String email, String mobileNo,
			List<Enrollments> enrollments) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobileNo = mobileNo;
		this.enrollments = enrollments;
	}
	public void setEnrollments(List<Enrollments> enrollments) {
		this.enrollments = enrollments;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Student(int id, String firstName, String lastName, String dateOfBirth, String email,String mobileNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Sis [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	
	

}
