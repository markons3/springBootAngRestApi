package com.springAngRestApi.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;

import com.springAngRestApi.model.Employee;
import com.springAngRestApi.repository.EmployeeRespository;

public class EmployeeService {

	@Autowired
	private EmployeeRespository employeeRepository;

	public Employee save(Employee employee) {
		if (employee.getId() != null && employeeRepository.exists(employee.getId())) {
			throw new EntityExistsException("There is alerady existing enitity with such ID");
		}
		return employeeRepository.save(employee);
	}
	
	public Employee update(Employee employee) {
		if (employee.getId() != null && employeeRepository.exists(employee.getId())) {
			throw new EntityExistsException("There is alerady existing enitity with such ID");
		}
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	public Employee findOne(Integer id){
		return employeeRepository.findOne(id);
	}
	
	public void delete(Integer id) {
		employeeRepository.delete(id);
	}
}