package com.anurag.emsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.emsb.entity.Employee;
import com.anurag.emsb.repository.EmployeeRepository;

@Service
public class EmployeeService {
      @Autowired // dependency injection
      private EmployeeRepository repo;
      // EmployeeRepositoryImpl class object will be created

      public Employee createEmployee(Employee emp) {
            return repo.save(emp);
      }

      public List<Employee> getAllEmployees() {
            return repo.findAll();
      }

      public String deleteEmployee(Integer id) {
            if (repo.existsById(id)) {
                  repo.deleteById(id);
                  return "Employee Deleted Successfully";
            }
            return "Employee not found";
      }

      public Employee updateEmployee(Integer id, Employee newEmp) {
            Employee existingEmp = repo.findById(id).orElse(null);
            if (existingEmp != null) {
                  existingEmp.setName(newEmp.getName());
                  existingEmp.setRole(newEmp.getRole());
                  existingEmp.setEmail(newEmp.getEmail());
                  existingEmp.setPassword(newEmp.getPassword());
                  return repo.save(existingEmp);
            }
            return null;
      }
}
