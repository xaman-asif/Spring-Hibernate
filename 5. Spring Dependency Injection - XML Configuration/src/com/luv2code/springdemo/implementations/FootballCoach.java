package com.luv2code.springdemo.implementations;

import com.luv2code.springdemo.interfaces.Coach;

public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Dribble for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Today you will score goal";
	}

}
