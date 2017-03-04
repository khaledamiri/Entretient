package com.amiri.entretient.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amiri.entretient.dao.EmployeeIDAO;
import com.amiri.entretient.entity.Employee;

@Service
@Transactional
public class EmployeeMetierImpl implements EmployeeIMetier {
	
	@Autowired
	EmployeeIDAO employeeIDAO;



	@Override
	public void saveEmployee(Employee employee) {
		employeeIDAO.saveEmployee(employee);
		
	}
	@Override
	public void updateEmployee(Employee employee){
		employeeIDAO.updateEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(Integer idEmp) {
		employeeIDAO.deleteEmployeeById(idEmp);
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return employeeIDAO.findAllEmployees();
	}

	@Override
	public Employee findEmployeeById(Integer idEmp) {
		// TODO Auto-generated method stub
		return employeeIDAO.findEmployeeById(idEmp);
	}

}
