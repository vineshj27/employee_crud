package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.customexception.IdNotFoundException;
import com.employee.customexception.SalaryNotValidException;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
 

@RestController

public class EmployeeController {

	@Autowired
	
	EmployeeService es;
	
	@PostMapping(path="/post")
	public List<Employee> Post(@RequestBody List<Employee> e) {
		return es.Post(e);
	}
	
	@PostMapping(path="/single")
	   public String Single(@RequestBody Employee ep) {
			return es.Single(ep);
		}
	
	@GetMapping(path="/getpost")
	  public List<Employee> getpost() {
		  return es.getpost();
}
	@PostMapping(path="/salary")
	public String salary(@RequestBody List<Employee> empl) throws SalaryNotValidException {
		return es.salary(empl);
	}
	
	@GetMapping(path="/id/{eplo}")
	public Employee id(@PathVariable int eplo) throws IdNotFoundException {
		return es.id(eplo);
	}
	
	@GetMapping(path="/name/{abn}") 
	public List<Employee> getByName(@PathVariable String abn) throws SalaryNotValidException {
		return es.getByName(abn);
	}
	@PostMapping(path="/increment")
	public List<Employee> getByshift(@RequestBody Employee plt) {
		return es.getByshift(plt);
	}
	
	
	
	
	
	
	
	
	
	
	
}
