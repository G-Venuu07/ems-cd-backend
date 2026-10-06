package com.anurag.emsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.emsb.entity.Employee;
import com.anurag.emsb.service.EmployeeService;

@RestController
@RequestMapping("/employee")
// common path for all the end points
public class EmployeeController {
      @Autowired
      private EmployeeService service;

      @PostMapping("/add")
      public Employee createEmployee(@RequestBody Employee emp) {
            return service.createEmployee(emp);
      }

      @GetMapping("/get") // endpoint
      public List<Employee> getAllEmployee() {
            return service.getAllEmployees();
      }

      @DeleteMapping("/delete/{id}") // http://localhost:8080/1
      public String deleteEmployee(@PathVariable Integer id) {
            return service.deleteEmployee(id);
      }

      @PutMapping("/update/{id}") // http://localhost:8080/update/2
      public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee newEmp) {
            return service.updateEmployee(id, newEmp);
      }
}