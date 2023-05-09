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
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private CompanyService compService;
	
	@PostMapping("")
	public int post(@RequestBody Company company) {
		
		return companyMapper.insert(company);
	}
	
	@GetMapping("")
	public List<Company> getAll(){
		return compService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Company getById(@PathVariable("id") int id){
		return companyMapper.getById(id);
	}
	
	
}
