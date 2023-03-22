package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			// query all students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			// display the students
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			System.out.println("Done");
			
			// query students: lastName='Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Wall'").getResultList();
			// display the students
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			System.out.println("Done");
			
			// query students: where email LIKE '%luv2code.com'
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			// display the students
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}

}
