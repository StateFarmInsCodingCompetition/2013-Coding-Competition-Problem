//
//Do not change anything in the following JAVA class!
//
package com.sf.codingcomp.football;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
//
//Do not change anything in the following JAVA class!
//
public class FantasyFootballTest {

	private Team homeTeam;
	private Team awayTeam;
	private LeagueOptions options;

	@Before
	public void setup() {
		homeTeam = new Team();
		awayTeam = new Team();
		options = new LeagueOptions();
	}

	@Test
	public void testTooManyPlayers() {
		options.setMaximumPlayersAtEachPosition(1);
		try {
			homeTeam.addPlayer(new Quarterback(1, 1, true), options);
			homeTeam.addPlayer(new RunningBack(1, 1, true), options);
			homeTeam.addPlayer(new Quarterback(1, 1, true), options);
			fail("Too many quarterbacks added to the team");
		} catch (TooManyPlayersException tooMany) {
			// success
		}
	}

	@Test
	public void testHomeTeamWins_NoPartialPoints() throws Exception {
		options.setMaximumPlayersAtEachPosition(1);
		options.setPartialPointsAllowed(false);
		homeTeam.addPlayer(new Quarterback(3, 307, true), options);
		homeTeam.addPlayer(new RunningBack(1, 76, true), options);
		homeTeam.addPlayer(new WideReceiver(1, 112, true), options);
		awayTeam.addPlayer(new Quarterback(4, 264, true), options);
		awayTeam.addPlayer(new RunningBack(0, 87, true), options);
		awayTeam.addPlayer(new WideReceiver(1, 90, true), options);
		assertTrue(homeTeam.wins(awayTeam, options));
		assertEquals(57, homeTeam.total(options), 0);
		assertEquals(53, awayTeam.total(options), 0);
	}
	
	@Test
	public void testAwayTeamWins_NoPartialPoints() throws Exception {
		options.setMaximumPlayersAtEachPosition(2);
		options.setPartialPointsAllowed(false);
		homeTeam.addPlayer(new Quarterback(3, 307, true), options);
		homeTeam.addPlayer(new Quarterback(1, 202, true), options);
		homeTeam.addPlayer(new RunningBack(1, 76, true), options);
		homeTeam.addPlayer(new WideReceiver(1, 112, true), options);
		awayTeam.addPlayer(new Quarterback(4, 264, true), options);
		awayTeam.addPlayer(new Quarterback(4, 380, true), options);
		awayTeam.addPlayer(new RunningBack(0, 87, true), options);
		awayTeam.addPlayer(new WideReceiver(1, 90, true), options);
		assertFalse(homeTeam.wins(awayTeam, options));
		assertEquals(70, homeTeam.total(options), 0);
		assertEquals(88, awayTeam.total(options), 0);
	}
	
	@Test
	public void testHomeTeamWins_PartialPoints() throws Exception {
		options.setMaximumPlayersAtEachPosition(1);
		options.setPartialPointsAllowed(true);
		homeTeam.addPlayer(new Quarterback(3, 307, true), options);
		homeTeam.addPlayer(new RunningBack(1, 76, true), options);
		homeTeam.addPlayer(new WideReceiver(1, 112, true), options);
		awayTeam.addPlayer(new Quarterback(4, 264, true), options);
		awayTeam.addPlayer(new RunningBack(0, 87, true), options);
		awayTeam.addPlayer(new WideReceiver(1, 90, true), options);
		assertTrue(homeTeam.wins(awayTeam, options));
		assertEquals(58.08, homeTeam.total(options), 0);
		assertEquals(54.26, awayTeam.total(options), 0);
	}
	
	@Test
	public void testAwayTeamWins_PartialPoints() throws Exception {
		options.setMaximumPlayersAtEachPosition(1);
		options.setPartialPointsAllowed(true);
		homeTeam.addPlayer(new Quarterback(3, 307, true), options);
		homeTeam.addPlayer(new RunningBack(1, 76, true), options);
		homeTeam.addPlayer(new WideReceiver(1, 112, true), options);
		awayTeam.addPlayer(new Quarterback(4, 264, true), options);
		awayTeam.addPlayer(new RunningBack(1, 87, true), options);
		awayTeam.addPlayer(new WideReceiver(1, 90, true), options);
		assertFalse(homeTeam.wins(awayTeam, options));
		assertEquals(58.08, homeTeam.total(options), 0);
		assertEquals(60.26, awayTeam.total(options), 0);
	}
}
