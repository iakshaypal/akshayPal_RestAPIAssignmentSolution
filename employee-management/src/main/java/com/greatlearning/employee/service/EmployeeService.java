package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.entity.Role;
import com.greatlearning.employee.entity.User;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee employee);

	public void deleteById(int id);
	
	public List<Employee> searchByFirstName(String firstName);

    public List<Employee> sortByOrder(String order);

    public User saveUser(User user);

    public Role saveRole(Role role);

}
