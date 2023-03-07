package com.luv2code.springdemo;

import com.luv2code.springdemo.implementations.FootballCoach;
import com.luv2code.springdemo.implementations.TrackCoach;
import com.luv2code.springdemo.interfaces.Coach;

public class MyApp {

	public static void main(String[] args) {
		// Create the object
		Coach trackCoach = new TrackCoach();
		Coach footballCoach = new FootballCoach();
		
		// Use the object
		System.out.println(trackCoach.getDailyWorkout());

	}

}
