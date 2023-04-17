package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
   public List<Employee> findAll();

   public Employee findById(int theId);

   public Employee save(Employee theEmployee);

   public String deleteById(int theId);
}
