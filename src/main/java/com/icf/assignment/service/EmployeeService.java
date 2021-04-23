package com.icf.assignment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.icf.assignment.model.Dependant;
import com.icf.assignment.model.EducationQualification;
import com.icf.assignment.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
	List<Dependant> getAllDependant();
	void saveDependant(Dependant dependant);
	Dependant getDependantById(long id);
	void deleteDependantById(long id);
	Page<Dependant> findDependantPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
	List<EducationQualification> getAllEducationQualification();
	void saveEducationQualification(EducationQualification educationQualification);
	EducationQualification getEducationQualificationById(long id);
	void deleteEducationQualificationById(long id);
	Page<EducationQualification> findEducationQualificationPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
	
}
