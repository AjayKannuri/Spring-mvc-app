package com.dbs.springmvcapp.controller;
import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
public class UserRestController {
		
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(value="/users",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Employee> listAll()
	{
		System.out.println("Inside the list all method!!");
		return this.employeeService.listAll();
	}
	

	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable("id") long id)
	{
		return this.employeeService.findById(id);
	}
	
	
	@PostMapping("/employees")
	public void saveEmployee(@Valid @RequestBody Employee employee)
	{
		this.employeeService.saveEmployee(employee);
	}
}
