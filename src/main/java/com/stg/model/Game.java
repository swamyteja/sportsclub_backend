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
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gameId;
	private String gameName;
	private float gameCoachingFee;

	@JsonManagedReference(value = "game_player")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "game" )
	private List<Player> players;
	
	
	@JsonManagedReference(value = "game_coach")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "game")
	private List<Coach> coach;
	
	@JsonBackReference(value="sports_club_game")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "club_id", referencedColumnName = "clubId")
	private SportsClub sportsClub;

	public Game() {
		super();
	}

	public Game(int gameId, String gameName, float gameCoachingFee) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.gameCoachingFee = gameCoachingFee;
	}

	public List<Coach> getCoach() {
		return coach;
	}

	public void setCoach(List<Coach> coach) {
		this.coach = coach;
	}
	
	

	public SportsClub getSportsClub() {
		return sportsClub;
	}

	public void setSportsClub(SportsClub sportsClub) {
		this.sportsClub = sportsClub;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public float getGameCoachingFee() {
		return gameCoachingFee;
	}

	public void setGameCoachingFee(float gameCoachingFee) {
		this.gameCoachingFee = gameCoachingFee;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
