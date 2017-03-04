package com.amiri.entretient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amiri.entretient.entity.Employee;
import com.amiri.entretient.metier.EmployeeIMetier;

@Controller
@RequestMapping(value = "/")
public class EmployeeController {
//Comment 
	@Autowired
	EmployeeIMetier metier;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Employee> employees = metier.findAllEmployees();
		model.addAttribute("employees", employees);
		return "allemployees";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		metier.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getNameEmp()
				+ " registered successfully");
		return "success";
	}

	@RequestMapping(value = { "/edit-{idEmp}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String idEmp, ModelMap model) {
		Employee employee = metier.findEmployeeById(Integer.parseInt(idEmp));
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
	}

	@RequestMapping(value = { "/edit-{idEmp}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee,
			BindingResult result, ModelMap model, @PathVariable String idEmp) {

		if (result.hasErrors()) {
			return "registration";
		}

		metier.updateEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getNameEmp()
				+ " updated successfully");
		return "success";
	}

	@RequestMapping(value = { "/delete-{idEmp}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String idEmp) {
		metier.deleteEmployeeById(Integer.parseInt(idEmp));
		return "redirect:/list";
	}

}
