package com.greatlearning.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employee.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer> {

}
