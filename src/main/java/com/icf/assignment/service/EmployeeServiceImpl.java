package com.icf.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.icf.assignment.model.Dependant;
import com.icf.assignment.model.EducationQualification;
import com.icf.assignment.model.Employee;
import com.icf.assignment.repository.DependantRepository;
import com.icf.assignment.repository.EducationQualificationRepository;
import com.icf.assignment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DependantRepository dependantRepository;
	
	@Autowired
	private EducationQualificationRepository educationQualificationRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	

	@Override
	public List<Dependant> getAllDependant() {
		return dependantRepository.findAll();
	}
	
	@Override
	public List<EducationQualification> getAllEducationQualification() {
		// TODO Auto-generated method stub
		return educationQualificationRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}
	
	@Override
	public void saveDependant(Dependant dependant) {
		this.dependantRepository.save(dependant);
	}
	
	

	@Override
	public void saveEducationQualification(EducationQualification educationQualification) {
		// TODO Auto-generated method stub
		this.educationQualificationRepository.save(educationQualification);
	}
	

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}
	
	@Override
	public Dependant getDependantById(long id) {
		Optional<Dependant> optional = dependantRepository.findById(id);
		Dependant dependant = null;
		if (optional.isPresent()) {
			dependant = optional.get();
		} else {
			throw new RuntimeException(" Dependant not found for id :: " + id);
		}
		return dependant;
	}
	
	@Override
	public EducationQualification getEducationQualificationById(long id) {
		// TODO Auto-generated method stub
		Optional<EducationQualification> optional = educationQualificationRepository.findById(id);
		EducationQualification educationQualification = null;
		if (optional.isPresent()) {
			educationQualification = optional.get();
		} else {
			throw new RuntimeException(" education qualification not found for id :: " + id);
		}
		return educationQualification;
	}
	

	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}
	
	@Override
	public void deleteDependantById(long id) {
		this.dependantRepository.deleteById(id);
	}
	
	@Override
	public void deleteEducationQualificationById(long id) {
		// TODO Auto-generated method stub
		this.educationQualificationRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
	
	@Override
	public Page<Dependant> findDependantPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.dependantRepository.findAll(pageable);
	}


	@Override
	public Page<EducationQualification> findEducationQualificationPaginated(int pageNo, int pageSize, String sortField,
			String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.educationQualificationRepository.findAll(pageable);
	}
}
