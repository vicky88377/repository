package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addPlayer(Player player) {
		sessionFactory.getCurrentSession().saveOrUpdate(player);

	}

	@SuppressWarnings("unchecked")
	public List<Player> getAllPlayers() {

		return sessionFactory.getCurrentSession().createQuery("from Player")
				.list();
	}

	@Override
	public void deletePlayer(Integer playerId) {
		Player player = (Player) sessionFactory.getCurrentSession().load(
				Player.class, playerId);
		if (null != player) {
			this.sessionFactory.getCurrentSession().delete(player);
		}

	}

	public Player getPlayer(int empid) {
		return (Player) sessionFactory.getCurrentSession().get(
				Player.class, empid);
	}

	@Override
	public Player updatePlayer(Player player) {
		sessionFactory.getCurrentSession().update(player);
		return player;
	}

}