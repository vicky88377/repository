package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.PlayerDAO;
import com.jwt.model.Player;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDAO;

	@Override
	@Transactional
	public void addPlayer(Player player) {
		playerDAO.addPlayer(player);
	}

	@Override
	@Transactional
	public List<Player> getAllPlayers() {
		return playerDAO.getAllPlayers();
	}

	@Override
	@Transactional
	public void deletePlayer(Integer playerId) {
		playerDAO.deletePlayer(playerId);
	}

	public Player getPlayer(int empid) {
		return playerDAO.getPlayer(empid);
	}

	public Player updatePlayer(Player player) {
		// TODO Auto-generated method stub
		return playerDAO.updatePlayer(player);
	}

	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

}
