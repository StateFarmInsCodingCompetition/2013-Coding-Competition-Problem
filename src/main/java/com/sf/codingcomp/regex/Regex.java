package com.sf.codingcomp.regex;

public class Regex {
	/**
	 * 10 numbers.
	 * 
	 * @param ssn
	 * @return
	 */
	public static boolean isFullPhoneNumber(String phone) {
		String pattern = "\\d\\d\\d\\D{0,1}\\d\\d\\d\\D{0,1}\\d\\d\\d\\d";
		return phone.matches(pattern);
	}

	/**
	 * It is an address if it contains all 3 elements: Address (e.g. street &
	 * number or PO box number) City & State Zip code (5 or 9)
	 * 
	 * @param address
	 * @return
	 */
	public static boolean isAmericanAddress(String address) {
		String pattern = ".*\\d.* .* [A-Z][A-Z] \\d\\d\\d\\d\\d.*";
		return address.matches(pattern);
	}

	public static boolean isIPv4Address(String ip) {
		String pattern = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])."+
						"([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])."+
						"([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])."+
						"([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
				
		return ip.matches(pattern);
	}
}
