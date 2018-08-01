package com.jwt.dao;

import java.util.List;
import com.jwt.model.Player;

public interface PlayerDAO {

	public void addPlayer(Player player);

	public List<Player> getAllPlayers();

	public void deletePlayer(Integer playerId);

	public Player updatePlayer(Player player);

	public Player getPlayer(int playerid);
}
