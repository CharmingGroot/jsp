package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@PostMapping("")
	public int post(@RequestBody Employee employee) {
		
		return employeeMapper.insert(employee);
	}
	
	@GetMapping("")
	public List<Employee> getAll(){
		return employeeMapper.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") int id){
		return employeeMapper.getById(id);
	}
}
