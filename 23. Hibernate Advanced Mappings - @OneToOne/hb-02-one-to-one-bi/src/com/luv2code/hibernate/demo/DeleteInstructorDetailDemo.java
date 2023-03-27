package com.luv2code.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get the instructor by primary key / id
			int theId = 4;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			InstructorDetail tempInstructorDetail = tempInstructor.getInstructorDetail();
			
			if (tempInstructorDetail != null) {
				// deleting the instructor object
				System.out.println("deleting the instructorDetail Object: " + tempInstructorDetail);
				tempInstructorDetail.getInstructor().setInstructorDetail(null);
				session.delete(tempInstructorDetail);
			}
			
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
