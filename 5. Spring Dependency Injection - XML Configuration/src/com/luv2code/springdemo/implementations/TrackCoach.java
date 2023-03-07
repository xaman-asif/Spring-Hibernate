package com.luv2code.springdemo.implementations;

import com.luv2code.springdemo.interfaces.Coach;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run around the track";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Today will win in the track";
	}

}
