package com.sf.codingcomp.sample;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SampleTest {
	private Sample sample;
	
	@Before
	public void setup() {
		sample = new Sample();
	}
	
	@Test
	public void completelyEmpty() {
		assertTrue(sample.isBlank(""));
	}
	
	@Test
	public void oneSpace() {
		assertTrue(sample.isBlank(" "));
	}
	
	@Test
	public void multipleSpaces() {
		assertTrue(sample.isBlank("             "));
	}
	
	@Test
	public void oneTab() {
		assertTrue(sample.isBlank("	"));
	}
	
	@Test
	public void multipleTabs() {
		assertTrue(sample.isBlank("			"));	
	}
	
	@Test
	public void notBlank() {
		assertFalse(sample.isBlank("This isn't blank!"));
	}
	
	@Test
	public void alpha() {
		assertTrue(sample.isAlpha("asd"));
	}
	
	@Test
	public void notAlpha() {
		assertFalse(sample.isAlpha("123"));
	}
	
	@Test
	public void notAlphaMixed() {
		assertFalse(sample.isAlpha("asd123"));
	}
}
