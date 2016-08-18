package com.sf.codingcomp.security;

import java.util.List;

public class SecurityMatrix {

	private static final Role ADMIN = new Role("ADMIN");
	private static final Role DEV = new Role("DEV");
	private static final Role TEST = new Role("TEST");
	private static final Role READONLY = new Role("READONLY");

	static {
		try {
			createRole(ADMIN);
			createRole(DEV);
			createRole(TEST);
			createRole(READONLY);
			grantAccess(READONLY, Action.READ);
			grantAccess(DEV, Action.READ, Day.WEEKEND());
			grantAccess(TEST, Action.READ);
			grantAccess(TEST, Action.CREATE, Day.WORK_WEEK());
			grantAccess(TEST, Action.UPDATE, Day.WORK_WEEK());
			for (Action action : Action.values()) {
				grantAccess(ADMIN, action, Day.values());
				grantAccess(DEV, action, Day.WORK_WEEK());
			}
		} catch (RoleAlreadyExistsException e) {
			e.printStackTrace();
		}
	}

	public static void createRole(Role role) throws RoleAlreadyExistsException {
		// TODO implement me
	}

	public static boolean hasAccess(Role role, Day day, Action action) {
		// TODO implement me
		return false;
	}

	public static List<Day> findDays(Role role, Action action) {
		// TODO implement me
		return null;
	}

	public static List<Action> findActions(Role role, Day day) {
		// TODO implement me
		return null;
	}

	public static List<Role> findRoles(Day day, Action action) {
		// TODO implement me
		return null;
	}

	public static void grantAccess(Role role, Action action, Day... days) {
		// TODO implement me
	}

	public static void revokeAccess(Role role, Action action, Day... days) {
		// TODO implement me
	}

}
