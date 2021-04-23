package com.icf.assignment.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "user name should have atleast 2 characters")
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty
	private String lastName;
	
	@Column(name = "startDate")
	@NotEmpty
	private String startDate;
	
	@Column(name = "endDate")
	private String endDate;
	
	@Column(name = "designation")
	@NotEmpty
	private String designation;
	
	@Column(name = "department")
	@NotEmpty
	private String department;
	
	@Column(name = "employeeid")
	@NotEmpty
	private String employeeid;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "reportingManager")
	@NotEmpty
	private String reportingManager;
	
	@Column(name = "gender")
	@NotEmpty
	private String gender;
	
	@Column(name = "bloodgroup")
	private String bloodgroup;
	
	@Column(name = "status")
	@NotEmpty
	private String status;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "time")
	private LocalTime time;
	
	@Column(name = "RemoteAddress")
	private String RemoteAddress;
	
	@Column(name = "RemoteAgent")
	private String RemoteAgent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time2) {
		this.time = time2;
	}

	public String getRemoteAddress() {
		return RemoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		RemoteAddress = remoteAddress;
	}

	public String getRemoteAgent() {
		return RemoteAgent;
	}

	public void setRemoteAgent(String remoteAgent) {
		RemoteAgent = remoteAgent;
	}	

}