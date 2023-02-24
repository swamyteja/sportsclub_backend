package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exception.SportsClubException;
import com.stg.model.Game;

import com.stg.repository.GameRepository;


@Service
public class GameServiceImp implements GameService {
	
	@Autowired
	private GameRepository gameRepository;

	@Override
	public Game readByGameId(int gameId) throws SportsClubException {
		Game tempGame = gameRepository.findByGameId(gameId);

		if (tempGame != null && gameId == tempGame.getGameId()) {
			return gameRepository.findByGameId(gameId);
		} else {
			throw new SportsClubException("Game Id does not exits");
		}
	}

	@Override
	public Game readByGameName(String gameName) {
		Game tempGame = gameRepository.findByGameName(gameName);

		if (tempGame != null) {
			return gameRepository.findByGameName(gameName);
		} else {
			throw new SportsClubException("Game Name does not exits");
		}
	}


	@Override
	public Game createGame(Game game) {

		return gameRepository.save(game);
	}

	@Override
	public Game updateGame(int gameId, Game game)throws SportsClubException {
		
		Optional<Game> optional = gameRepository.findById(gameId);
		//int clubId = gameRepository.getClubIdWithGameId(gameId);
		 //System.out.println(clubId);
		if(optional.isPresent()) {
			game.setGameId(gameId);
			//System.out.println(clubId + " " + gameId);
			//gameRepository.setClubIdWithGameId(clubId, gameId);
		}else {
			throw new SportsClubException("GameId doesn't exists");
		}
		
		return gameRepository.save(game);
	}

	@Override
	public String deleteByGameId(int gameId) {
		Game tempGame = gameRepository.findByGameId(gameId);
		if (tempGame != null ) {
			gameRepository.deleteById(gameId);
		} else {
			throw new SportsClubException("Game does not exists");
		}
		return "Game DELETED SUCCESFULLY";
	}

	@Override
	public List<Game> getGameList() {
		return gameRepository.findAll();
	}

}
