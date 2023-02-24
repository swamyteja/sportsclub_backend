package com.stg.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	private String playerName;
	private int playerAge;
	private String playerGender;
	private String location;
	private String playerContactNo;

	
	@JsonBackReference(value = "sports_club_player")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "club_id", referencedColumnName = "clubId",nullable = false)
	private SportsClub sportsClub;

	
	@JsonBackReference(value = "game_player")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "game_id", referencedColumnName = "gameId",nullable = false)
	private Game game;
	
	
	@JsonBackReference(value="players_coach")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name = "coach_id", referencedColumnName = "coachId",nullable = false)
	private Coach coach;

	public Player() {
		super();

	}
	
	
	public Player(int playerId, String playerName, int playerAge, String playerGender, String location,
			String playerContactNo) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerAge = playerAge;
		this.playerGender = playerGender;
		this.location = location;
		this.playerContactNo = playerContactNo;
	}





	public Player(int playerId, String playerName, int playerAge, String playerContactNo, SportsClub sportsClub,
			Game game, Coach coach) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerAge = playerAge;
		this.playerContactNo = playerContactNo;
		this.sportsClub = sportsClub;
		this.game = game;
		this.coach = coach;
	}
	
	public String getClubName() {
		return sportsClub.getClubName();
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	public String getCoachName() {
		return coach.getCoachName();
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
	}

	public String getPlayerContactNo() {
		return playerContactNo;
	}

	public void setPlayerContactNo(String playerContactNo) {
		this.playerContactNo = playerContactNo;
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

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public String getGender() {
		return playerGender;
	}

	public void setGender(String playerGender) {
		this.playerGender = playerGender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

}
