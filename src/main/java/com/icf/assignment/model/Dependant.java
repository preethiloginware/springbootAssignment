package com.icf.assignment.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "dependant")
public class Dependant {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	@NotEmpty
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "relationship")
	private String relationship;
	
	@Column(name = "gender")
	private String gender;
	
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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
