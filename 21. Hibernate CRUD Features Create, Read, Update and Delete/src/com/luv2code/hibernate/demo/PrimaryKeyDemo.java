package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
				
		try {
			// use the session object to save Java object
			// create a student object
			System.out.println("creating 3 student objects");
			
			String theDateOfBirthStr = "31/01/2000";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			Student tempStudent1 = new Student("Paul", "Wall", "paul@luv2code.com", theDateOfBirth);
			Student tempStudent2 = new Student("White", "Walker", "white@luv2code.com", theDateOfBirth);
			Student tempStudent3 = new Student("Robert", "Frost", "robert@luv2code.com", theDateOfBirth);
			
			// start a transaction
			session.beginTransaction();
					
			// save these student objects
			System.out.println("saving these student object");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
					
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
					
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}		
	}
}
