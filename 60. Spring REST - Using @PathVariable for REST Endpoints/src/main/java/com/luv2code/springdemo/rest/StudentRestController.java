package com.luv2code.springdemo.rest;


import com.luv2code.springdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        theStudents.add(new Student(0, "Poornima", "Patel"));
        theStudents.add(new Student(1, "Alex", "Jones"));
    }

    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{theStudentId}")
    public Student getStudent(@PathVariable int theStudentId) {
        Student theStudent = theStudents.get(theStudentId);

        return theStudent;
    }

}
