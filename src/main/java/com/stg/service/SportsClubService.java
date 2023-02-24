package com.stg.service;


import java.util.List;

import com.stg.model.SportsClub;


public interface SportsClubService {
	
	public abstract SportsClub readByClubId(int clubId);

	public abstract SportsClub readByClubName(String clubName);
	
	public abstract  List<SportsClub> getSportsClubList();
	 
	public abstract SportsClub createSportClub(SportsClub sportsClub) ;

	public abstract SportsClub updateSportsClub(int clubId, SportsClub sportsClub) ;

	public abstract String deleteByClubId(int clubId);

}
