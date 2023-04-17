package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entitymanager

    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        // using native hibernate API
        Query theQuery =
                currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        // return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save the employee
        currentSession.saveOrUpdate(theEmployee);

        // return the employee
        return theEmployee;
    }

    @Override
    public String deleteById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        // return the employee
        if (theEmployee != null) {
            currentSession.delete(theEmployee);
        } else {
            return "No Employee found on id - " + theId;
        }

        return "Deleted Employee on id - " + theId;
    }
}
