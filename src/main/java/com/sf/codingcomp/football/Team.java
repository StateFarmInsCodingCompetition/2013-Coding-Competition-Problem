package com.sf.codingcomp.football;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private List<Player> players = new ArrayList<Player>();

	public void addPlayer(Player player, LeagueOptions options) throws TooManyPlayersException {
		// TODO implement method
	}

	public boolean wins(Team opponent, LeagueOptions options) {
		// TODO implement method
		return false;
	}

	public double total(LeagueOptions options) {
		// TODO implement method
		return -1;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
