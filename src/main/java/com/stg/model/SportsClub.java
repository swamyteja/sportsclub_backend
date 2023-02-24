package com.stg.model;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class SportsClub {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clubId;
	private String clubName;
	private String location;
	private String contactNo;


	@JsonManagedReference(value = "sports_club_player")
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "sportsClub")
	private List<Player> players;
	
	@JsonManagedReference(value = "sports_club_coach")
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "sportsClub")
	private List<Coach> coach;
	
	@JsonManagedReference(value="sports_club_game")
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "sportsClub")
	private List<Game> game;

	public SportsClub() {
		super();
	}

	public SportsClub(int clubId, String clubName, String location, String contactNo) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.location = location;
		this.contactNo = contactNo;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Coach> getCoach() {
		return coach;
	}

	public void setCoach(List<Coach> coach) {
		this.coach = coach;
	}

	public List<Game> getGame() {
		return game;
	}

	public void setGame(List<Game> game) {
		this.game = game;
	}
	
	

}
