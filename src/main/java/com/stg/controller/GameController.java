package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.stg.model.Game;

import com.stg.service.GameServiceImp;

@RestController
@RequestMapping(value = "game")
@CrossOrigin(origins="http://localhost:4200")
public class GameController {
	
	@Autowired
	private GameServiceImp gameServiceImp;
	
	
	@GetMapping(value = "/readbygameid/{gameId}")
	public Game getGameById(@PathVariable int gameId) {
		return gameServiceImp.readByGameId(gameId);
	}
	
	@GetMapping(value = "/readbygamename/{gameName}")
	public Game getGameByName(@PathVariable String gameName) {
		return gameServiceImp.readByGameName(gameName);
	}
	
	@GetMapping(value = "getGameList")
	public List<Game> readPlayers(){
		return gameServiceImp.getGameList();
	}
	
	@PostMapping(value ="/createGame",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Game createGame(@RequestBody Game game) {
		return gameServiceImp.createGame(game);
	}
	
	@PutMapping(value = "/upadtegame/{gameId}")
	public Game updategameById(@PathVariable int gameId,@RequestBody Game game)   {
		return gameServiceImp.updateGame(gameId, game);
	}
	
	@DeleteMapping(value = "/deletegame/{gameId}")
	public String deleteGameById(@PathVariable int gameId){
		return gameServiceImp.deleteByGameId(gameId);
	}
	
}
