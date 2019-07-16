package com.arnab.emp.repo;

import org.springframework.data.repository.CrudRepository;

import com.arnab.emp.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
