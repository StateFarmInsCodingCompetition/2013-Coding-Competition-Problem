package com.sf.codingcomp.security;

public enum Day {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	public static Day[] WORK_WEEK() {
		return new Day[]{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};
	}
	
	public static Day[] WEEKEND() {
		return new Day[]{SATURDAY, SUNDAY};
	}
}
