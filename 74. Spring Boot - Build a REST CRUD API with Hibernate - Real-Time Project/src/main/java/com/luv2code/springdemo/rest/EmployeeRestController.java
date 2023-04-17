package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Employee;
import com.luv2code.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{theId}")
    public Employee findById(@PathVariable int theId) {
        return employeeService.findById(theId);
    }

    @PostMapping ("/employees")
    public Employee save(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{theId}")
    public String deleteById(@PathVariable int theId) {
        return employeeService.deleteById(theId);
    }

    @PutMapping ("/employees")
    public Employee update(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }
}
