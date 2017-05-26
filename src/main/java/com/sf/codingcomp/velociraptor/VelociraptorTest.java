//
//Do not change anything in the following JAVA class!
//
package com.sf.codingcomp.velociraptor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//
//Do not change anything in the following JAVA class!
//
public class VelociraptorTest {
	/**
	 * If you are having difficulty, try passing the "easy" tests first.
	 * They should be easier to pass and will allow you to debug your
	 * application with small numbers.
	 * Comments are included in the methods that start with "easy" that will
	 * give you base numbers to compare to your implementation.
	 * 
	 * If you waste your time on the internet, you might be consumed by a 
	 * Velociraptor and you certainly would not win the competition.
	 * If you want to waste some time, go read some XKCD. It will help
	 * your friends catch up to you.
	 * http://xkcd.com/135/
	 * http://xkcd.com/292/
	 * http://xkcd.com/87/
	 * http://xkcd.com/155/
	 */
	private Velociraptor raptie;

	@Before
	public void setup() {
		raptie = new Velociraptor();
	}

	@Test
	public void usainBoltTest() {
		// Usain Bolt's average speed is 24mph, rounded up.
		// Close Usain Bolt
		Prey usainBolt = new Prey(24, 10);
		int catchSpeed = raptie.catchPrey(usainBolt, 10);
		assertEquals(30, catchSpeed);


		// Far Usain Bolt, barely within reach.
		usainBolt = new Prey(24, 221);
		catchSpeed = raptie.catchPrey(usainBolt, 10);
		assertEquals(46, catchSpeed);

		// Far Usain Bolt, not within reach.
		usainBolt = new Prey(24, 1000);
		catchSpeed = raptie.catchPrey(usainBolt, 0);
		assertEquals(-1, catchSpeed);
	}

	@Test
	public void cheetahTest() {
		// A cheetah's top speed is 64mph based on conventional measurements.
		// Close Cheetah
		Prey cheetah = new Prey(64, 10);
		int catchSpeed = raptie.catchPrey(cheetah, 0);
		assertEquals(-1, catchSpeed);

		// Far Cheetah
		// Raptie starts at 40mph
		cheetah = new Prey(64, 10000);
		catchSpeed = raptie.catchPrey(cheetah, 40);
		assertEquals(-1, catchSpeed);
	}

	@Test
	public void greatDaneTest() {
		// A Great Dane's top speed is 30mph.
		// Close Great Dane
		Prey greatDane = new Prey(30, 10);
		int catchSpeed = raptie.catchPrey(greatDane, 0);
		assertEquals(-1, catchSpeed);

		// Close Great Dane
		// Raptie starts at 10mph
		greatDane = new Prey(30, 10);
		catchSpeed = raptie.catchPrey(greatDane, 10);
		assertEquals(-1, catchSpeed);

		// Close Great Dane
		// Raptie starts at 20mph
		greatDane = new Prey(30, 10);
		catchSpeed = raptie.catchPrey(greatDane, 20);
		assertEquals(22, catchSpeed);

		// Close Great Dane
		// Raptie starts at 30mph
		greatDane = new Prey(30, 10);
		catchSpeed = raptie.catchPrey(greatDane, 30);
		assertEquals(5, catchSpeed);

		// Close Great Dane
		// Raptie starts at 40mph
		greatDane = new Prey(30, 10);
		catchSpeed = raptie.catchPrey(greatDane, 40);
		assertEquals(1, catchSpeed);

		// Far Great Dane
		// Raptie starts at 30mph
		greatDane = new Prey(30, 100);
		catchSpeed = raptie.catchPrey(greatDane, 30);
		assertEquals(13, catchSpeed);

		// Far Great Dane
		// Raptie starts at 40mph
		greatDane = new Prey(30, 100);
		catchSpeed = raptie.catchPrey(greatDane, 40);
		assertEquals(-1, catchSpeed);
	}

	@Test
	public void easyTestSnail() {
		// For all intents and purposes, a snail does not move.

		// First turn, Raptie moves 0ft
		// Second turn, Raptie moves 1.46.. feet
		// Third turn, Raptie moves 2.93.. feet
		Prey snail = new Prey(0, 2);
		int catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(3, catchSpeed);

		// First turn, Raptie moves 0ft
		// Second turn, Raptie moves 1.46.. feet
		snail = new Prey(0, 1);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(2, catchSpeed);

		// First turn, Raptie moves 1.46.. feet
		snail = new Prey(0, 1);
		catchSpeed = raptie.catchPrey(snail, 1);
		assertEquals(1, catchSpeed);
	}

	@Test
	public void testSnail() {
		// Our snail is obviously not from the animated movie
		Prey snail = new Prey(0, 2347);
		int catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(-1, catchSpeed);

		snail = new Prey(0, 2346);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(80, catchSpeed);

		snail = new Prey(0, 2345);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(79, catchSpeed);	

		snail = new Prey(0, 2342);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(78, catchSpeed);

		snail = new Prey(0, 2340);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(78, catchSpeed);

		snail = new Prey(0, 2300);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(73, catchSpeed);

		snail = new Prey(0, 1100);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(40, catchSpeed);

		snail = new Prey(0, 1090);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(40, catchSpeed);

		snail = new Prey(0, 1085);
		catchSpeed = raptie.catchPrey(snail, 0);
		assertEquals(39, catchSpeed);
	}

	@Test
	public void easyTestTortoise() {
		// The Giant Galapagos Turtle moves at 1mph.

		// First turn, Raptie moves 0ft
		// First turn, Torty moves 1.46.. feet
		// Torty is now 3.46ft away.
		//
		// Second turn, Raptie moves 1.46.. feet
		// Second turn, Torty moves 1.46.. feet
		// Torty is now 3.46ft away.
		//
		// Third turn, Raptie moves 2.93.. feet
		// Third turn, Torty moves 1.46.. feet
		// Torty loses 1.46.. feet of ground
		// Torty is now 2ft away.
		//
		// Fourth turn, Raptie moves 4.4 feet
		// Fourth turn, Torty moves 1.46.. feet
		// Torty loses 2.93.. feet of ground
		// Torty is caught! (0.93.. ft to spare)
		Prey torty = new Prey(1, 2);
		int catchSpeed = raptie.catchPrey(torty, 0);
		assertEquals(4, catchSpeed);

		// First turn, Raptie moves 0ft
		// First turn, Torty moves 1.46.. feet
		// Torty is 2.46.. feet away
		//
		// Second turn, Raptie moves 1.46.. feet
		// Second turn, Torty moves 1.46.. feet
		// Torty is 2.46.. feet away
		//
		// Third turn, Raptie moves 2.93.. feet
		// Third turn, Torty moves 1.46.. feet
		// Torty loses 1.46.. feet of ground
		// Torty is 1 foot away
		//
		// Fourth turn, Raptie moves 4.4 feet
		// Fourth turn, Torty moves 1.46.. feet
		// Torty loses 2.93.. feet of ground
		// Torty is caught! (1.93.. ft to spare)
		torty = new Prey(1, 1);
		catchSpeed = raptie.catchPrey(torty, 0);
		assertEquals(4, catchSpeed);

		// First turn, Raptie moves 1.46.. feet
		// First turn, Torty moves 1.46.. feet
		// Torty is still 1 foot away
		//
		// Second turn, Raptie moves 2.93.. feet
		// Second turn, Torty moves 1.46.. feet
		// Torty loses 1.46.. feet of ground
		// Torty is caught! (0.46.. feet to spare)
		torty = new Prey(1, 1);
		catchSpeed = raptie.catchPrey(torty, 1);
		assertEquals(2, catchSpeed);
	}

	@Test
	public void testTortoise() {
		// The tortoise might win a race against a hare,
		// but not against a Velociraptor.
		Prey torty = new Prey(1, 200);
		int catchSpeed = raptie.catchPrey(torty, 0);
		assertEquals(19, catchSpeed);
		
		torty = new Prey(1, 200);
		catchSpeed = raptie.catchPrey(torty, 1);
		assertEquals(18, catchSpeed);
		
		torty = new Prey(1, 200);
		catchSpeed = raptie.catchPrey(torty, 20);
		assertEquals(7, catchSpeed);
		
		torty = new Prey(1, 2000);
		catchSpeed = raptie.catchPrey(torty, 0);
		assertEquals(62, catchSpeed);
		
		torty = new Prey(1, 2000);
		catchSpeed = raptie.catchPrey(torty, 20);
		assertEquals(-1, catchSpeed);
	}

	@Test
	public void easyTestShihTzu() {
		// First turn, Raptie moves 36.6.. feet
		// First turn, Shih-Tzu moves 11.73.. feet
		// Shih-Tzu is caught! (14.93.. feet to spare)
		Prey shihTzu = new Prey(8, 10);
		int catchSpeed = raptie.catchPrey(shihTzu, 25);
		assertEquals(1, catchSpeed);

		// The Shih-Tzu started at the feet of the Velociraptor!
		// Poor dog. :(
		shihTzu = new Prey(8, 0);
		catchSpeed = raptie.catchPrey(shihTzu, 1);
		assertEquals(0, catchSpeed);
		
		// The Shih-Tzu started at the feet of the Velociraptor!
		// It doesn't matter if the Velociraptor didn't move on
		// the first turn; the Shih-Tzu was already there.
		shihTzu = new Prey(8, 0);
		catchSpeed = raptie.catchPrey(shihTzu, 0);
		assertEquals(0, catchSpeed);
	}
	
	@Test
	public void testShihTzu() {
		// Shih-Tzus are not fast dogs
		Prey shihTzu = new Prey(8, 1000);
		int catchSpeed = raptie.catchPrey(shihTzu, 0);
		assertEquals(48, catchSpeed);

		shihTzu = new Prey(8, 500);
		catchSpeed = raptie.catchPrey(shihTzu, 0);
		assertEquals(36, catchSpeed);

		shihTzu = new Prey(8, 500);
		catchSpeed = raptie.catchPrey(shihTzu, 37);
		assertEquals(12, catchSpeed);

		shihTzu = new Prey(8, 1163);
		catchSpeed = raptie.catchPrey(shihTzu, 30);
		assertEquals(42, catchSpeed);
		
		// Our dog is safe at 100,000 feet!
		shihTzu = new Prey(8, 100000);
		catchSpeed = raptie.catchPrey(shihTzu, 30);
		assertEquals(-1, catchSpeed);
	}
}
