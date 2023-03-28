package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			// start a transaction
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 4;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			session.close();
			
			System.out.println("luv2code: Done!");
			
			// get course for the instructor
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			
			factory.close();
		}
	}
}
