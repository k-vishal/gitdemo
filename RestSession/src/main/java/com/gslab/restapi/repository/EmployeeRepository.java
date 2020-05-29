package com.gslab.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gslab.restapi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
