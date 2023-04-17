package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int theId);

    public Employee save(Employee theEmployee);

    public String deleteById(int theId);
}
