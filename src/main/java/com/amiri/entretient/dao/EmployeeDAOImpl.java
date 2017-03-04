package com.amiri.entretient.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amiri.entretient.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeIDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee2 = findEmployeeById(employee.getIdEmp());
		session.saveOrUpdate(employee2);
	}

	@Override
	public void deleteEmployeeById(Integer idEmp) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session
				.createQuery("delete from Employee e where e.idEmp=:idEmp ");
		query.setInteger("idEmp", idEmp);
		query.executeUpdate();

	}

	@Override
	public List<Employee> findAllEmployees() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Employee>) session.createQuery("from Employee").list();
	}

	@Override
	public Employee findEmployeeById(Integer idEmp) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Employee e where e.idEmp=:idEmp ");
		query.setInteger("idEmp", idEmp);
		return (Employee) query.uniqueResult();
	}

}
