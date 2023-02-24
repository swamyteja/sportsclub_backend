package com.stg.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
	
	public Game findByGameId(int gameId);

	public Game findByGameName(String gameName);

	public void deleteById(int gameId);
	
	@Query(value="select club_id from game where game_id = :gameId", nativeQuery = true)
	public int getClubIdWithGameId(int gameId);
	
	@Transactional
	@Modifying
	@Query(value="update game set club_id = :clubId where game_id = :gameId", nativeQuery = true)
	public void setClubIdWithGameId(int clubId, int gameId);
	
}