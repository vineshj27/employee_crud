package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.customexception.IdNotFoundException;
import com.employee.customexception.SalaryNotValidException;
import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service

public class EmployeeService {

	@Autowired
	
	EmployeeRepository er;

	EmployeeDao ed;

	public List<Employee> Post(List<Employee> e) {
		return ed.Post(e);
	}

	public String Single(Employee epl) {
		return ed.Single(epl);

	}

	public List<Employee> getpost() {
		return ed.getpost();

	}

	public String salary(List<Employee> epm) throws SalaryNotValidException {

		List<Employee> emply = epm.stream().filter(x -> x.getSalary() < 50000).toList();
		if (emply.isEmpty()) {
			throw new SalaryNotValidException("not valid salary");
		} else {
			return ed.salary(emply);
		}
	}
	
	public Employee id(int emlo) throws IdNotFoundException {
		  return ed.id(emlo);
		
	}
	
	public List<Employee>  getByName(String nba) throws SalaryNotValidException {
		
		List<Employee> values = getpost();
		
		List<Employee> names = values.stream().filter(x->x.getName().equalsIgnoreCase(nba)).toList();
		if(names.isEmpty()) {
			throw new SalaryNotValidException("Entered name is invalid");
		}                                       //notcreatedNameNotValidException so used SalaryNotValidException.
		else {
			return names;
		}
		
	}
	 
	public List<Employee> getByshift(Employee mpl) {
		List<Employee> emps = getpost();
		List<Employee> valus = emps.stream().filter(x->x.getShift().equalsIgnoreCase("night")).peek(x->x.setSalary(x.getSalary()+x.getSalary()*2/100)).toList();
		return er.saveAll(valus);
		
	}
		
		
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


