package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			System.out.println("creating a student object");
			
			String theDateOfBirthStr = "31/01/2000";
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			Student tempStudent = new Student("Daffy", "Wall", "daffy@luv2code.com", theDateOfBirth);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving the student object");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: " + myStudent);
			
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
