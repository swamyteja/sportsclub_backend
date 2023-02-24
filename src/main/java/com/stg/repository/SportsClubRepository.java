package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.stg.model.SportsClub;

@Repository
public interface SportsClubRepository extends JpaRepository<SportsClub, Integer> {
	
	 public SportsClub findByClubId(int clubId); 

	public SportsClub findByClubName(String clubName);

	public void deleteById(int clubId);

}
