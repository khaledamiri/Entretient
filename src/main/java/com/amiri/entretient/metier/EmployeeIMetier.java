package com.amiri.entretient.metier;

import java.util.List;

import com.amiri.entretient.entity.Employee;

public interface EmployeeIMetier {

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeById(Integer idEmp);

	List<Employee> findAllEmployees();

	Employee findEmployeeById(Integer idEmp);

}
