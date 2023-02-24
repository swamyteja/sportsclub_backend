package com.stg.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Coach {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coachId;
	private String coachName;
	private int coachExperience;
	private String coachSpecialization;

	@JsonBackReference(value = "sports_club_coach")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "club_id", referencedColumnName = "clubId",nullable = false)
	private SportsClub sportsClub;

	@JsonBackReference(value = "game_coach")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "game_id", referencedColumnName = "gameId",nullable = false)
	private Game game;
	
	@JsonManagedReference(value="players_coach")
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "coach")
	private List<Player> players;

	public Coach() {
		super();
	}

//	public Coach(int coachId, String coachName, int coachExperience, String coachSpecialization) {
//		super();
//		this.coachId = coachId;
//		this.coachName = coachName;
//		this.coachExperience = coachExperience;
//		this.coachSpecialization = coachSpecialization;
//	}
	

	public Coach(int coachId, String coachName, int coachExperience, String coachSpecialization, SportsClub sportsClub,
			Game game, List<Player> players) {
		super();
		this.coachId = coachId;
		this.coachName = coachName;
		this.coachExperience = coachExperience;
		this.coachSpecialization = coachSpecialization;
		this.sportsClub = sportsClub;
		this.game = game;
		this.players = players;
	}

	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	
	public String getGameName() {
		return game.getGameName();
	}
	
	public String getClubName() {
		return sportsClub.getClubName();
	}
	
	
	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public int getCoachExperience() {
		return coachExperience;
	}

	public void setCoachExperience(int coachExperience) {
		this.coachExperience = coachExperience;
	}

	public String getCoachSpecialization() {
		return coachSpecialization;
	}

	public void setCoachSpecialization(String coachSpecialization) {
		this.coachSpecialization = coachSpecialization;
	}

	public SportsClub getSportsClub() {
		return sportsClub;
	}

	public void setSportsClub(SportsClub sportsClub) {
		this.sportsClub = sportsClub;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	

}
