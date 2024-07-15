package com.backend.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ems.entity.Employees;
import com.backend.ems.exceptions.ResourceNotFoundException;
import com.backend.ems.service.EmsService;


@CrossOrigin("*")
@RestController
@RequestMapping("/ems/employees")
public class EmsController {
	
	@Autowired
	private EmsService service;
	
	@GetMapping
	public List<Employees> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	public Employees createEmployee(@RequestBody Employees e) {
		return service.createEmp(e);
	}
	
//	findByid
	@GetMapping("{id}")
	public ResponseEntity<Employees> EmployeeById(@PathVariable long id) throws ResourceNotFoundException{
		Employees e = service.EmployeeById(id).orElseThrow(()-> new ResourceNotFoundException("There is no employee with that Id.."));
		return new ResponseEntity<>(e,HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Employees> updateEmployee(@RequestBody Employees e, @PathVariable long id) throws ResourceNotFoundException{ 
		Employees e1 = service.EmployeeById(id).orElseThrow(()-> new ResourceNotFoundException("There is no employee with that Id.."));
		e1.setEmailId(e.getEmailId());
		e1.setFirstname(e.getFirstname());
		e1.setLastname(e.getLastname());
		return new ResponseEntity<>(service.updateEmployee(e1),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) throws ResourceNotFoundException{
		Employees e1 = service.EmployeeById(id).orElseThrow(()-> new ResourceNotFoundException("There is no employee with that Id.."));
        service.deleteEmployee(e1);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.NOT_FOUND);
	}
	

}
