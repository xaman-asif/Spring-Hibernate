package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// use the session object to save Java object
			
			// create a course
			Course tempCourse = new Course("Pacman - How to score one million");
			
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool course ... loved it!"));
			tempCourse.addReview(new Review("Dumb course ... loved it!"));
			
			// save the course
			System.out.println("Saving the course");
			session.save(tempCourse);
			
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
