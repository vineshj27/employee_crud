package com.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.customexception.IdNotFoundException;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Repository

public class EmployeeDao {

	@Autowired
	
	EmployeeRepository er;
	
	public List<Employee> Post(List<Employee> emp) {
		return er.saveAll(emp);
	}
	
	  public String Single(Employee el) {
			  er.save(el);
			 return "saved";
	  }
	
	  public List<Employee> getpost() {
		  return er.findAll();
	  
	  }
	  
	  public String salary(List<Employee> eml) {
		   er.saveAll(eml);
          return "saved";
	  }
	  
	  public String id(List<Employee> pl) {
		  er.saveAll(pl);
		  return "saved";
	  }
	  
	  public Employee id(int emlop) throws IdNotFoundException {
		  return er.findById(emlop).orElseThrow(()-> new IdNotFoundException("not valid"));
	 	  
}
//	  public List<Employee> getByshift(Employee yee) {
//		 return er.saveAll(yee);
//	  }
//	  
	  
	  
	  
}