//
//Do not change anything in the following JAVA class!
//
package com.sf.codingcomp.regex;

import static org.junit.Assert.*;

import org.junit.Test;
//
//Do not change anything in the following JAVA class!
//
public class RegexTest {
	@Test
	public void isFullPhoneNumber() {
		assertTrue(Regex.isFullPhoneNumber("191-428-2958"));
		assertTrue(Regex.isFullPhoneNumber("1938257165"));
		assertTrue(Regex.isFullPhoneNumber("3095728492"));
		assertTrue(Regex.isFullPhoneNumber("184 328 1922"));
		
		assertFalse(Regex.isFullPhoneNumber("12-01-2002"));
		assertFalse(Regex.isFullPhoneNumber("12345678"));
		assertFalse(Regex.isFullPhoneNumber("123456789101010123123123"));
		assertFalse(Regex.isFullPhoneNumber("XX Hwy 280, Birmingham, AL 35147"));
	}
	
	@Test
	public void isAmericanAddressTest() {
		assertTrue(Regex.isAmericanAddress("12 Hwy 280, Birmingham, AL 35147"));
		assertTrue(Regex.isAmericanAddress("3 State Farm Pl S, Bloomington, IL 61701"));
		assertTrue(Regex.isAmericanAddress("PO Box 1, Bloomington, IL 61701"));
		assertTrue(Regex.isAmericanAddress("3 State Farm Pl S Bloomington IL 61701-0000"));
		assertTrue(Regex.isAmericanAddress("3 State Farm Pl S Bloomington IL 617010000"));
		
		assertFalse(Regex.isAmericanAddress("Bloomington IL 61701"));
		assertFalse(Regex.isAmericanAddress("3 State Farm PL S 61701"));
		assertFalse(Regex.isAmericanAddress("61701"));
		assertFalse(Regex.isAmericanAddress("State Farm Pl S, Bloomington, IL 61701"));
	}
	
	@Test
	public void isIPv4AddressTest() {
		assertTrue(Regex.isIPv4Address("1.1.1.1"));
		assertTrue(Regex.isIPv4Address("192.168.1.1"));
		assertTrue(Regex.isIPv4Address("255.255.255.1"));
		
		assertFalse(Regex.isIPv4Address("255.255.255.256"));
		assertFalse(Regex.isIPv4Address("123"));
		assertFalse(Regex.isIPv4Address("1.2.3."));
		assertFalse(Regex.isIPv4Address("-1.2.4.5"));
		assertFalse(Regex.isIPv4Address("a.1.4.2"));
		assertFalse(Regex.isIPv4Address("1a.2.4.5"));
	}
}
