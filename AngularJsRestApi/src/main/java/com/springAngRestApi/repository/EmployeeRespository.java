package com.springAngRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springAngRestApi.model.Employee;

public interface EmployeeRespository extends JpaRepository<Employee,Integer>{

	Employee findByName(String name);
}
