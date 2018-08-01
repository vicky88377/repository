package com.jwt.service;

import java.util.List;

import com.jwt.model.Player;

public interface PlayerService {
	
	public void addPlayer(Player player);

	public List<Player> getAllPlayers();

	public void deletePlayer(Integer playerId);

	public Player getPlayer(int playerid);

	public Player updatePlayer(Player player);
}
