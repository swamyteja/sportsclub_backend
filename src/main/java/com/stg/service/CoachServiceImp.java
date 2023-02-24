package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stg.exception.SportsClubException;
import com.stg.model.Coach;
import com.stg.repository.CoachRepository;

@Service
public class CoachServiceImp implements CoachService {
	
	@Autowired
	private CoachRepository coachRepository;

	@Override
	public Coach readyByCoachId(int coachId) throws SportsClubException {
		Coach tempCoach = coachRepository.findByCoachId(coachId);
		System.out.println(tempCoach.getGame().getGameName());
		if(tempCoach != null && coachId == tempCoach.getCoachId()) {
			return tempCoach;
		}else {
		   throw new SportsClubException("Coach Id Does't Exists");
		}
	}

	@Override
	public Coach readyByCoachName(String coachName) throws SportsClubException {
		Coach tempCoachName = coachRepository.findByCoachName(coachName);
		if(tempCoachName != null ) {
			return coachRepository.findByCoachName(coachName);
		}else {
		   throw new SportsClubException("Coach Name Does't Exists");
		}
	}

	@Override
	public Coach readyByCoachExperience(int coachExperience) {
		Coach tempCoachExp = coachRepository.findByCoachExperience(coachExperience);
		if(tempCoachExp != null) {
			return coachRepository.findByCoachExperience(coachExperience);
		}else {
		   throw new SportsClubException("Coach Experience Does't Exists");
		}
	}


	@Override
	public Coach readbyCoachSpecialization(String coachSpecialization) {
		Coach tempCoachSpecialization = coachRepository.findByCoachSpecialization(coachSpecialization);
		if(tempCoachSpecialization != null ) {
			return coachRepository.findByCoachSpecialization(coachSpecialization);
		}else {
		   throw new SportsClubException("Coach Specialization Does't Exists");
		}
	}
	
	@Override
	public Coach createCoach(Coach coach)throws SportsClubException {
		Coach tempCoach = coachRepository.findByCoachName(coach.getCoachName());

		if (tempCoach == null) {
			return coachRepository.save(coach);
		} else {
			throw new SportsClubException("Coach already Exits");
		}
	}

	@Override
	public Coach updateCoach(int coachId, int coachExperience) {
		Coach tempCoach = coachRepository.findByCoachId(coachId);
        if (tempCoach!=null) {
        	tempCoach.setCoachExperience(coachExperience);
        	return coachRepository.save(tempCoach);
        }
        else {
              throw new SportsClubException("No Coach with this ID");
        }
	}

	@Override
	public String deleteByCoachId(int coachId) throws SportsClubException {
		Coach tempCoach =coachRepository.findByCoachId(coachId);
		if (tempCoach != null ) {
			coachRepository.deleteById(coachId);
		} else {
			throw new SportsClubException("CoachId does not exists");
		}
		
		return "Coach DELETED SUCCESFULLY";
	}

	@Override
	public List<Coach> getCoachList() {
		return coachRepository.findAll();
	}



}
