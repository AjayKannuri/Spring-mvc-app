package com.dbs.springmvcapp.service;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //private EmployeeDAO employeeDAO;
    
    
    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository)
    {
        //this.employeeDAO = employeeDAO;
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
       // return employeeDAO.save(employee);
    	
    	return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public List<Employee> listAll() {
        //return this.employeeDAO.findAll();
    	List<Employee> list = new ArrayList<>();
    	this.employeeRepository.findAll().forEach(employee -> list.add(employee));
    	return list;
    }

    @Override
    @Transactional
    public Employee findById(long empId)  {
        //return this.employeeDAO.findById(empId);
    	//return null;
    	return this.employeeRepository.findById(empId).get();
    }

    @Override
    @Transactional
    public void deleteEmployee(long empId) {
       // this.employeeDAO.deleteEmployee(empId);
    	this.employeeRepository.delete(this.employeeRepository.findById(empId).get());
    }
}