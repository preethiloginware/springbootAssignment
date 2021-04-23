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

import com.icf.assignment.model.Dependant;
import com.icf.assignment.repository.EmployeeRepository;
import com.icf.assignment.service.EmployeeService;
import com.icf.assignment.service.EmployeeServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DependantTest {
	@Autowired
	EmployeeRepository eRepo;
	
	@Autowired
	EmployeeServiceImpl serviceImpl;
	
	@Autowired
	EmployeeService service;
	

	@Test
	@Order(1)
	public void testDependant() {
		Dependant dependant = new Dependant();
		dependant.setId(1);
		dependant.setFirstName("preethi");
		dependant.setLastName("kk");
		dependant.setDob("kjf");
		dependant.setRelationship("23");
		dependant.setGender("123");
		
		serviceImpl.saveDependant(dependant);
		assertNotNull(serviceImpl.getDependantById(1).getId());
	}
	
	@Test
	@Order(2)
	public void testReadAllDependant() {
		List<Dependant> list =  serviceImpl.getAllDependant();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testUpdateDependant() {
	Dependant dependant = serviceImpl.getDependantById(1);	
	dependant.setGender("male");
	serviceImpl.saveDependant(dependant);
	assertEquals("male", serviceImpl.getDependantById(1).getGender());
	}
	
	@Test
	@Order(4)
	public void testDeleteDependant() {
		serviceImpl.deleteDependantById(1);
		List<Dependant> list =  serviceImpl.getAllDependant();
		assertTrue(list.isEmpty());
	}
	
}
