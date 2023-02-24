package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.model.Coach;


@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {
	
	public Coach findByCoachId(int coachId);
	
	public Coach findByCoachExperience(int coachExperience);

	public Coach findByCoachName(String coachName);

	public Coach findByCoachSpecialization(String coachSpecialization);

	public void deleteById(int coachId);

}
