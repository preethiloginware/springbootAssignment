package com.icf.assignment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.icf.assignment.model.EducationQualification;
import com.icf.assignment.repository.EmployeeRepository;
import com.icf.assignment.service.EmployeeService;
import com.icf.assignment.service.EmployeeServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EducationQualificationTest {
	@Autowired
	EmployeeRepository eRepo;
	
	@Autowired
	EmployeeServiceImpl serviceImpl;
	
	@Autowired
	EmployeeService service;
	

	@Test
	@Order(1)
	public void testEducationQualification() {
		EducationQualification educationQualification = new EducationQualification();
		educationQualification.setId(1);
		educationQualification.setStartDate("preethi");
		educationQualification.setEndDate("kk");
		educationQualification.setType("kjf");
		educationQualification.setAddress("23");
		educationQualification.setInstitution("123");
		educationQualification.setPercentage("12.3");
		
		serviceImpl.saveEducationQualification(educationQualification);
		assertNotNull(serviceImpl.getEducationQualificationById(1).getId());
	}
	
	@Test
	@Order(2)
	public void testReadAllEducationQualification() {
		List<EducationQualification> list =  serviceImpl.getAllEducationQualification();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testUpdateEducationQualification() {
		EducationQualification educationQualification = serviceImpl.getEducationQualificationById(1);	
	educationQualification.setEndDate("6-9-2031");
	serviceImpl.saveEducationQualification(educationQualification);
	assertEquals("6-9-2031", serviceImpl.getEducationQualificationById(1).getEndDate());
	}
	
	@Test
	@Order(4)
	public void testDeleteEducationQualification() {
		serviceImpl.deleteEducationQualificationById(1);
		List<EducationQualification> list =  serviceImpl.getAllEducationQualification();
		assertTrue(list.isEmpty());
	}
}
