package com.greatlearning.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.entity.Roles;
import com.greatlearning.employee.entity.User;
import com.greatlearning.employee.repository.EmployeeRepository;
import com.greatlearning.employee.repository.RoleRepository;
import com.greatlearning.employee.repository.UserRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptEncoder;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeByFirstname(firstName.toLowerCase());
	}

	@Override
	public List<Employee> sortByOrder(String order) {
		// TODO Auto-generated method stub
		List<Employee> employees = null;

		if (order.toLowerCase().equals("asc")) {
			employees = employeeRepository.findAllByOrderByFirstnameAsc();
		} else if (order.toLowerCase().equals("desc")) {
			employees = employeeRepository.findAllByOrderByFirstnameDesc();
		} else {
			throw new RuntimeException("No proper order mentioned");
		}
		return employees;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Roles saveRole(Roles role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

}
