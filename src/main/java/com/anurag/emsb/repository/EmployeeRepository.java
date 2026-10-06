package com.anurag.emsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anurag.emsb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
