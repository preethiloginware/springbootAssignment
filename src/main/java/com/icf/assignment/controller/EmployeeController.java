package com.icf.assignment.controller;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icf.assignment.model.Dependant;
import com.icf.assignment.model.EducationQualification;
import com.icf.assignment.model.Employee;
import com.icf.assignment.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// display list of employees
	@GetMapping("/EmployeeForm")
	public String viewHomePage(Model model) {
		return findPaginated(1, "firstName", "asc", model);
	}

	/**
	 * Display all Dependants Information
	 */
	@GetMapping("/DependantForm")
	public String viewDependantHomePage(Model model1) {
		return findDependantPaginated(1, "firstName", "asc", model1);
	}

	/****
	 * Display all Education Qualification Information
	 * 
	 * @param model1
	 * @return
	 */

	@GetMapping("/EducationqualificationForm")
	public String viewEducationQualificationHomePage(Model model1) {
		return findEducationQualificationPaginated(1, "type", "asc", model1);
	}

	@GetMapping("/")
	public String HomePage() {

		return "home";
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@GetMapping("/showNewDependantForm")
	public String showNewDependantForm(Model model) {
		Dependant dependant = new Dependant();
		model.addAttribute("dependant", dependant);
		return "new_dependant";
	}

	@GetMapping("/showNewEducationQualificationForm")
	public String showNewEducationQualificationForm(Model model) {
		EducationQualification educationQualification = new EducationQualification();
		model.addAttribute("educationQualification", educationQualification);
		return "new_educationQualification";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid @RequestBody @ModelAttribute("employee") Employee employee,
			HttpServletRequest httpServletRequest, BindingResult bindingResult) {
		/** saving employee to database */

		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		LocalTime time = LocalTime.now(zoneId);
		System.out.print(time);

		List list = new ArrayList<>();
		employee.setRemoteAddress(httpServletRequest.getRemoteAddr());
		employee.setTime(time);
		employee.setRemoteAgent(httpServletRequest.getHeader("User-Agent"));
		employeeService.saveEmployee(employee);
		return "redirect:/EmployeeForm";

	}

	@PostMapping("/saveDependant")
	public String saveDependant(@Valid @ModelAttribute("dependant") Dependant dependant,
			HttpServletRequest httpServletRequest) {

		/** save dependant information to database **/

		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		LocalTime time = LocalTime.now(zoneId);
		System.out.print(time);

		List list = new ArrayList<>();
		dependant.setRemoteAddress(httpServletRequest.getRemoteAddr());
		dependant.setTime(time);
		dependant.setRemoteAgent(httpServletRequest.getHeader("User-Agent"));
		employeeService.saveDependant(dependant);
		return "redirect:/DependantForm";
	}

	@PostMapping("/saveEducationQualification")
	public String saveEducationQualification(
			@Valid @ModelAttribute("educationQualification") EducationQualification educationQualification,
			HttpServletRequest httpServletRequest) {
		// save Education Qualification information to database

		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		LocalTime time = LocalTime.now(zoneId);
		System.out.print(time);
		educationQualification.setRemoteAddress(httpServletRequest.getRemoteAddr());
		educationQualification.setTime(time);
		educationQualification.setRemoteAgent(httpServletRequest.getHeader("User-Agent"));
		employeeService.saveEducationQualification(educationQualification);
		return "redirect:/EducationqualificationForm";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/showFormForUpdateDependant/{id}")
	public String showFormForUpdateDependant(@PathVariable(value = "id") long id, Model model) {

		/**
		 * get dependant from the service
		 */
		Dependant dependant = employeeService.getDependantById(id);
		model.addAttribute("dependant", dependant);
		return "update_dependant";
	}

	@GetMapping("/showFormForUpdateEducationQualification/{id}")
	public String showFormForUpdateEducationQualification(@PathVariable(value = "id") long id, Model model) {

		EducationQualification educationQualification = employeeService.getEducationQualificationById(id);
		model.addAttribute("educationQualification", educationQualification);
		return "update_educationQualification";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {

		// call delete employee method by id
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/EmployeeForm";
	}

	@GetMapping("/deleteDependant/{id}")
	public String deleteDependant(@PathVariable(value = "id") long id) {

		// call delete dependant method by id
		this.employeeService.deleteDependantById(id);
		return "redirect:/DependantForm";
	}

	@GetMapping("/deleteEducationQualification/{id}")
	public String deleteEducationQualification(@PathVariable(value = "id") long id) {

		// call delete education qualification method by id
		this.employeeService.deleteEducationQualificationById(id);
		return "redirect:/EducationqualificationForm";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}

	@GetMapping("/page1/{pageNo}")
	public String findDependantPaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Dependant> page = employeeService.findDependantPaginated(pageNo, pageSize, sortField, sortDir);
		List<Dependant> listDependant = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listDependant", listDependant);
		return "dependant";
	}

	@GetMapping("/page2/{pageNo}")
	public String findEducationQualificationPaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<EducationQualification> page = employeeService.findEducationQualificationPaginated(pageNo, pageSize,
				sortField, sortDir);
		List<EducationQualification> listEducationQualification = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listEducationQualification", listEducationQualification);
		return "educationQualification";
	}
}