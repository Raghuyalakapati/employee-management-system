package com.backend.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.ems.entity.Employees;

public interface EmsRepository extends JpaRepository<Employees,Long>{
	// all crud operations

}
