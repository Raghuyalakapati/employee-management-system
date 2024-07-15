package com.backend.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ems.entity.Employees;
import com.backend.ems.repository.EmsRepository;

@Service
public class EmsService {
	
	@Autowired
	private EmsRepository repo;

	public List<Employees> getAll() {
		return repo.findAll();
	}

	public Employees createEmp(Employees e) {
		return repo.save(e);
	}

	public Optional<Employees> EmployeeById(long id) {
		return repo.findById(id);
	}

	public Employees updateEmployee(Employees e1) {
		return repo.save(e1);
	}

	public void deleteEmployee(Employees e1) {
		repo.delete(e1);
		
	}






}
