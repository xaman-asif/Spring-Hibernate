package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			// use the session object to save Java object
			// create the courses
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			Course tempCourse1 = new Course("Air Guiter - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// save the instructor object
//			session.save(tempInstructor);
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
