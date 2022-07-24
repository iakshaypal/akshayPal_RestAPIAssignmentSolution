package com.greatlearning.employee.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.service.EmployeeService;

@RestController

public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return employeeService.saveUser(user);
	}

//	@PostMapping("/role")
//	public Role saveRole(@RequestBody Role role) {
//		return employeeService.saveRole(role);
//	}

	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		System.out.println(currentPrincipalName);
		return employeeService.findAll();
	}

	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		return employeeService.findById(employeeId);
	}

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	// @RequestMapping(value = "/{authorizationUrl}",method=RequestMethod.DELETE)
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteById(employeeId);
		return "Employee details with id - " + employeeId + " deleted";
	}

	@GetMapping("/employee/search/{firstName}")
	public List<Employee> searchEmployeesByFirstName(@PathVariable String firstName) {
		return employeeService.searchByFirstName(firstName);
	}

	@GetMapping("/employee/sort")
	public List<Employee> sortEmployeesInOrder(@RequestParam("order") String order) {
		return employeeService.sortByOrder(order);
	}

}