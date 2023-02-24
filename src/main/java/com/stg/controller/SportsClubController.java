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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.SportsClub;
import com.stg.service.SportsClubServiceImp;

@RestController
@RequestMapping(value ="sportsclub")
@CrossOrigin(origins = "http://localhost:4200")
public class SportsClubController {

	@Autowired
	private SportsClubServiceImp sportsClubServiceImp;
	
	@GetMapping(value = "/readbyclubid/{clubId}")
	public SportsClub getClubById(@PathVariable int clubId){
		return sportsClubServiceImp.readByClubId(clubId);
	}
	
	@GetMapping(value = "/readbyclubname/{clubName}")
	public SportsClub getClubByName(@RequestParam String clubName){
		return sportsClubServiceImp.readByClubName(clubName);
	}
	
	@GetMapping(value = "getsportsClubList")
	public List<SportsClub> readSportsClubs(){
		return sportsClubServiceImp.getSportsClubList();
	}
	
	@PostMapping(value = "/createSportsClub",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public SportsClub createSportsClub(@RequestBody SportsClub sportsClub) {
		
		return sportsClubServiceImp.createSportClub(sportsClub);
	}
	
	@PutMapping(value = "/upadteSportsClub/{clubId}")
	public SportsClub updateSportsClubById(@PathVariable int clubId,@RequestBody SportsClub sportsClub)   {
		return sportsClubServiceImp.updateSportsClub(clubId, sportsClub);
	}

	@DeleteMapping(value = "/deleteclub/{clubId}")
	public String deleteClubById(@PathVariable int clubId){
		return sportsClubServiceImp.deleteByClubId(clubId);
	}
	
	
	
	
	
}
