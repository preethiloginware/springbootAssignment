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
@Table(name = "educationQualification")
public class EducationQualification {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "type")
	@NotEmpty
	private String type;
	
	@Column(name = "startDate")
	@NotEmpty
	private String startDate;
	
	@Column(name = "endDate")
	private String endDate;
	
	@Column(name = "institution")
	@NotEmpty
	private String institution;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "percentage")
	@NotEmpty
	private String percentage;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
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
