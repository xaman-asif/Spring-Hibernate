package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.interfaces.Coach;

public class HelloSpringApp {
	public static void main(String[] args) {
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");		
		
		//retrieve bean from spring container
//		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		Coach footballCoach = context.getBean("footballCoach", Coach.class);
		
		//call methods on the bean
//		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());
		
		//close the context
		context.close();
	
	}
}
