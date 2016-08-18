package com.sf.codingcomp.arena;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

//
//Do not change anything in the following JAVA class!
//

public class ArenaTest {

	private Arena arena;
	private Character warrior;
	private Character mage;

	@Before
	public void setup() {
		arena = new Arena();
		warrior = new Character();
		mage = new Character();
	}

	@Test
	public void warriorHasNoStamina() {
		warrior.setAttack(50);
		warrior.setDefense(100);
		warrior.setStamina(2);
		mage.setAttack(150);
		mage.setDefense(10);
		mage.setStamina(1);
		try {
			arena.fight(warrior, mage);
			arena.fight(warrior, mage);
			arena.fight(warrior, mage);
			fail();
		} catch (NoStaminaException nse) {
			// success
		}
	}

	@Test
	public void warriorAttacksAndWins() throws Exception {
		warrior.setAttack(50);
		warrior.setDefense(100);
		warrior.setStamina(1);
		mage.setAttack(150);
		mage.setDefense(10);
		mage.setStamina(0);
		assertEquals(warrior, arena.fight(warrior, mage));
	}

	@Test
	public void warriorAttacksAndWins_tie() throws Exception {
		warrior.setAttack(50);
		warrior.setDefense(100);
		warrior.setStamina(1);
		mage.setAttack(100);
		mage.setDefense(50);
		mage.setStamina(0);
		assertEquals(warrior, arena.fight(warrior, mage));
	}

	@Test
	public void mageAttacksAndWins() throws Exception {
		warrior.setAttack(50);
		warrior.setDefense(100);
		warrior.setStamina(0);
		mage.setAttack(150);
		mage.setDefense(10);
		mage.setStamina(1);
		assertEquals(mage, arena.fight(mage, warrior));
	}

	@Test
	public void warriorAttacksAndLoses() throws Exception {
		warrior.setAttack(50);
		warrior.setDefense(100);
		warrior.setStamina(1);
		mage.setAttack(200);
		mage.setDefense(90);
		mage.setStamina(0);
		assertEquals(mage, arena.fight(warrior, mage));
	}

	@Test
	public void mageAttacksAndLoses() throws Exception {
		warrior.setAttack(50);
		warrior.setDefense(100);
		warrior.setStamina(0);
		mage.setAttack(60);
		mage.setDefense(10);
		mage.setStamina(1);
		assertEquals(warrior, arena.fight(mage, warrior));
	}

}
