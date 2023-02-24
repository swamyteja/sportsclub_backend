package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.SportsClubException;

import com.stg.model.SportsClub;
import com.stg.repository.SportsClubRepository;

@Service
public class SportsClubServiceImp implements SportsClubService {
	
	@Autowired
	private SportsClubRepository sportsClubRepository;

	@Override
	public SportsClub readByClubId(int clubId) throws SportsClubException {
		SportsClub tempSportClub = sportsClubRepository.findById(clubId).orElse(null);

		if (tempSportClub != null) {
			return tempSportClub;
		} else {
			throw new SportsClubException("SportsClub Id does not exits");
		}
		
	}

	@Override
	public SportsClub readByClubName(String clubName) {
		SportsClub tempSportClub = sportsClubRepository.findByClubName(clubName);

		if (tempSportClub != null) {
			return tempSportClub;
		} else {
			throw new SportsClubException("SportsClub Name does not exits");
		}
	}

	@Override
	public SportsClub createSportClub(SportsClub sportsClub) {
		SportsClub tempSportClub = sportsClubRepository.findByClubName(sportsClub.getClubName());

		if (tempSportClub == null) {
			return sportsClubRepository.save(sportsClub);
		} else {
			throw new SportsClubException("SportsClub already Exits");
		}
	}

	@Override
	public SportsClub updateSportsClub(int clubId, SportsClub sportsClub)throws SportsClubException {
		
		Optional<SportsClub> optional = sportsClubRepository.findById(clubId);
		 
		if(optional.isPresent()) {
			sportsClub.setClubId(clubId);
		}else {
			throw new SportsClubException("SportsId doesn't exists");
		}
       
		return sportsClubRepository.save(sportsClub);
	}

	@Override
	public String deleteByClubId(int clubId) throws SportsClubException{
		SportsClub tempSportsClub = sportsClubRepository.findByClubId(clubId);
		if (tempSportsClub != null ) {
			sportsClubRepository.deleteById(clubId);
		} else {
			throw new SportsClubException("ClubId does not exists");
		}
		return "SportsClub DELETED SUCCESFULLY";
	}

	@Override
	public List<SportsClub> getSportsClubList() {
		return sportsClubRepository.findAll();
	}
	

}
