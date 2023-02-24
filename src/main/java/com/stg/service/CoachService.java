package com.stg.service;


import java.util.List;

import com.stg.model.Coach;


public interface CoachService {

	public abstract Coach readyByCoachId(int coachId);

	public abstract Coach readyByCoachName(String coachName);

	public abstract Coach readyByCoachExperience(int coachExperience);
	
	public abstract  List<Coach> getCoachList();


	public abstract Coach readbyCoachSpecialization(String coachSpecialization);
	
	public abstract Coach createCoach(Coach coach) ;
	
	public abstract Coach updateCoach(int coachId,int coachExperience) ;

	public abstract String deleteByCoachId(int coachId);

}
