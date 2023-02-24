package com.stg.service;


import java.util.List;

import com.stg.model.Player;


public interface PlayerService {
	
	public abstract Player readByPlayerId(int playerId);

	public abstract Player readByPlayerName(String playerName);
	
	public abstract  List<Player> getPlayerList();

	public abstract Player createPlayer(Player player) ;

	public abstract Player updatePlayer(int playerId, int playerAge) ;

	public abstract String deleteByPlayerId(int playerId);

	
}
