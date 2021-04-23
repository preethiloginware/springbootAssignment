package com.icf.assignment;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.icf.assignment.model.Employee;
import com.icf.assignment.repository.EmployeeRepository;
import com.icf.assignment.service.EmployeeService;
import com.icf.assignment.service.EmployeeServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SpringbootAssignmentWebAppApplicationTest {

	@Autowired
	EmployeeRepository eRepo;
	
	@Autowired
	EmployeeServiceImpl serviceImpl;
	
	@Autowired
	EmployeeService service;
	
	
	@Test
	@Order(1)
	public void testEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstName("preethi");
		employee.setLastName("kk");
		employee.setStartDate("kjf");
		employee.setEndDate("23");
		employee.setEmployeeid("123");
		employee.setDepartment("gjfdk");
		employee.setDesignation("asd");
		employee.setStatus("active");
		employee.setReportingManager("hjk");
		employee.setAddress("hassan");
		employee.setBloodgroup("a+");
		employee.setDob("dfjgk");
		employee.setGender("female");
		serviceImpl.saveEmployee(employee);
		assertNotNull(serviceImpl.getEmployeeById(1).getId());
		
	}
	
	@Test
	@Order(2)
	public void testReadAllEmployee() {
		List<Employee> list =  serviceImpl.getAllEmployees();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testUpdate() {
	//	Employee employee = new Employee();
	Employee employee = serviceImpl.getEmployeeById(1);	
	employee.setAddress("boovanahalli");
	serviceImpl.saveEmployee(employee);
	assertEquals("boovanahalli", serviceImpl.getEmployeeById(1).getAddress());
	}
	
	@Test
	@Order(4)
	public void testDeleteEmployee() {
		serviceImpl.deleteEmployeeById(1);
		List<Employee> list =  serviceImpl.getAllEmployees();
		assertTrue(list.isEmpty());
	}	
}

