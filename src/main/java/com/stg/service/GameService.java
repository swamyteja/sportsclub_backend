package com.stg.service;

import java.util.List;

import com.stg.model.Game;



public interface GameService {
	
	public abstract Game readByGameId(int gameId) ;

	public abstract Game readByGameName(String gameName) ;

	public abstract Game createGame(Game game) ;
	
	public abstract  List<Game> getGameList();

	public abstract Game updateGame(int gameId, Game game) ;

	public abstract String deleteByGameId(int gameId);
}
