package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.Coach;

import com.stg.service.CoachServiceImp;


@RestController
@RequestMapping(value = "coach")
@CrossOrigin(origins = "http://localhost:4200")
public class CoachController {

	@Autowired
	private CoachServiceImp coachServiceImp;

	@GetMapping(value = "/readByCoachId/{coachId}")
	public Coach getCoachById(@PathVariable int coachId) {
		return coachServiceImp.readyByCoachId(coachId);
	}
	
	@GetMapping(value = "/readByCoachName/{coachName}")
	public Coach getCoachByName(@PathVariable String coachName) {
		return coachServiceImp.readyByCoachName(coachName);
	}
	
	@GetMapping(value = "/readByCoachExperience/{coachexperience}")
	public Coach getCoachByCoachexperience(@PathVariable int coachexperience) {
		return coachServiceImp.readyByCoachExperience(coachexperience);
	}

	@GetMapping(value = "getCoachList")
	public List<Coach> readAllCoaches(){
		return coachServiceImp.getCoachList();
	}
	
	@GetMapping(value = "/readByCoachSpecialization/{coachSpecialization}")
	public Coach getCoachBySpecialization(@PathVariable String coachSpecialization) {
		return coachServiceImp.readbyCoachSpecialization(coachSpecialization);
	}
	
	@PostMapping(value = "/createCoach", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Coach createCoach(@RequestBody Coach coach) {
		return coachServiceImp.createCoach(coach);
	}
	
	@PutMapping(value = "/upadteCoachExperience/{coachId}/{coachExp}")
	public Coach updateCoachExpereience(@PathVariable int coachId,@PathVariable int coachExp)   {
		return coachServiceImp.updateCoach(coachId, coachExp);
	}
	
	@DeleteMapping(value = "/deleteCoach/{coachId}")
	public String deleteCoachById(@PathVariable int coachId){
		return coachServiceImp.deleteByCoachId(coachId);
	}
	
	
	

}
