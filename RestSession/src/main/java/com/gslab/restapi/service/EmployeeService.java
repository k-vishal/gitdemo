package com.gslab.restapi.service;

import java.util.List;

import com.gslab.restapi.entity.Employee;

public interface EmployeeService {

	public void createEmployee(Employee employeeObj);
	public  List<Employee> getAllEmployee();
	public Employee findById(long id);
	public  Employee update(Employee employeeObj, long l);
	public void deleteEmployeeById(long id);
	
}
