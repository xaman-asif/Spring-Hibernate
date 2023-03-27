package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			// create the objects
			Instructor tempInstructor1 = 
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail tempInstructorDetail1 =
					new InstructorDetail(
							"http://www.luv2code.com/youtube",
							"I Love to Code!!!"
							);
			
			Instructor tempInstructor2 = 
					new Instructor("Simp", "Son", "simp@luv2code.com");
			InstructorDetail tempInstructorDetail2 =
					new InstructorDetail(
							"http://www.luv2code.com/simpson",
							"I Love to Simp!!!"
							);
			
			// associate the objects
			tempInstructor1.setInstructorDetail(tempInstructorDetail1);
			tempInstructor2.setInstructorDetail(tempInstructorDetail2);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor object
			System.out.println("Saving the instructor: " + tempInstructor1);
			session.save(tempInstructor1);
			
			System.out.println("Saving the instructor: " + tempInstructor2);
			session.save(tempInstructor2);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
