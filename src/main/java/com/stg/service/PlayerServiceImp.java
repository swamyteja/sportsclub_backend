package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.SportsClubException;
import com.stg.model.Coach;
import com.stg.model.Player;

import com.stg.repository.PlayerRepository;

@Service
public class PlayerServiceImp implements PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;

	

	@Override
	public Player readByPlayerId(int playerId) throws SportsClubException {
		Player tempPlayer = playerRepository.findByPlayerId(playerId);

		if (tempPlayer != null && playerId == tempPlayer.getPlayerId()) {
			return playerRepository.findByPlayerId(playerId);
		} else {
			throw new SportsClubException("Player Id does not exits");
		}
	}

	@Override
	public Player readByPlayerName(String playerName)throws SportsClubException {
		Player tempPlayer = playerRepository.findByPlayerName(playerName);

		if (tempPlayer != null && playerName == tempPlayer.getPlayerName()) {
			return playerRepository.findByPlayerName(playerName);
		} else {
			throw new SportsClubException("Player Name does not exits");
		}
		
	}

	@Override
	public Player createPlayer(Player player)throws SportsClubException {
			return playerRepository.save(player);
	}

	
	@Override
	public String deleteByPlayerId(int playerId) {
		Player tempPlayer = playerRepository.findByPlayerId(playerId);
		if (tempPlayer != null ) {
			playerRepository.deleteById(playerId);
		} else {
			throw new SportsClubException("PlayerId does not exists");
		}
		return "Player DELETED SUCCESFULLY";
	}

	@Override
	public List<Player> getPlayerList() {
		return playerRepository.findAll();
	}

	@Override
	public Player updatePlayer(int playerId, int playerAge) {
		Player tempPlayer = playerRepository.findByPlayerId(playerId);
        if (tempPlayer!=null) {
        	tempPlayer.setPlayerAge(playerAge);
        	return playerRepository.save(tempPlayer);
        }
        else {
              throw new SportsClubException("No Player with this ID");
        }
	}

}
