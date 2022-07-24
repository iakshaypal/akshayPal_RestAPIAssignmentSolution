package com.greatlearning.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	 @Query("SELECT e FROM Employee e WHERE LOWER(e.firstname) LIKE %:firstname%")
	    List<Employee> findEmployeeByFirstname(@Param("firstname") String firstname);

	    List<Employee> findAllByOrderByFirstnameAsc();

	    List<Employee> findAllByOrderByFirstnameDesc();

}
