package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	public Player findByPlayerId(int playerId);

	public Player findByPlayerName(String playerName);

	public void deleteById(int playerId);
	
}
