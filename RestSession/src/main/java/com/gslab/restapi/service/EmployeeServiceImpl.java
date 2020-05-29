package com.gslab.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.restapi.entity.Employee;
import com.gslab.restapi.exception.ResourceNotFoundException;
import com.gslab.restapi.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepoObj;

	@Override
	public void createEmployee(Employee employeeObj) {
		employeeRepoObj.save(employeeObj);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeRepoObj.findAll();
	}

	@Override
	public Employee findById(long id) {
		return employeeRepoObj.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee update(Employee employeeObj, long l) {
		return employeeRepoObj.save(employeeObj);
	}

	@Override
	public void deleteEmployeeById(long id) {
		employeeRepoObj.deleteById(id);
	}
	

}
