package com.sf.codingcomp.duck;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//
//Do not change anything in the following JAVA class!
//

public class DuckTest {

	@Test
	public void isADuck() {
		assertTrue(DuckFinder.isADuck(new Object(){
			public void looksLikeADuck() {
			}

			public void quacksLikeADuck() {
			}
		}));
		assertFalse(DuckFinder.isADuck(new Duck()));
	}

	@Test
	public void isADuckADuckNow() {
		assertFalse(DuckFinder.isADuck(new Duck() {
			private void looksLikeADuck() {
			}

			public void quacksLikeADuck() {
			}
		}));
		assertTrue(DuckFinder.isADuck(new Duck() {
			public void looksLikeADuck() {
			}
			
			public void quacksLikeADuck() {
			}
		}));
	}

}
