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


import com.stg.model.Player;

import com.stg.service.PlayerServiceImp;

@RestController
@RequestMapping(value="player")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {
	
	@Autowired
	private PlayerServiceImp playerServiceImp;
	
	@GetMapping(value = "/readbyplayerid/{playerId}")
	public Player getPlayerById(@PathVariable int playerId){
		return playerServiceImp.readByPlayerId(playerId);
	}
	
	@GetMapping(value = "/readbyplayername/{playerName}")
	public Player getPlayerByName(@PathVariable String playerName){
		return playerServiceImp.readByPlayerName(playerName);
	}
	
	@GetMapping(value = "getPlayerList")
	public List<Player> readPlayers(){
		return playerServiceImp.getPlayerList();
	}
	
	@PostMapping(value = "/createplayer",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Player createPlayer(@RequestBody Player player) {
		
		return playerServiceImp.createPlayer(player);
	}
	
	@PutMapping(value = "/updatePlayer/{playerId}/{playerAge}")
	public Player updatePlayerById(@PathVariable int playerId,@PathVariable int playerAge)   {
		return playerServiceImp.updatePlayer(playerId, playerAge);
	}
	
	@DeleteMapping(value = "/deleteplayer/{playerId}")
	public String deletePlayerById(@PathVariable int playerId){
		return playerServiceImp.deleteByPlayerId(playerId);
	}
	
	
}
