//
//Do not change anything in the following JAVA class!
//
package com.sf.codingcomp.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
//
//Do not change anything in the following JAVA class!
//
public class SecurityMatrixTest {

	@Test
	public void createNewRole() throws RoleAlreadyExistsException {
		Role elephant = new Role("ELEPHANT");
		SecurityMatrix.createRole(elephant);
		noAccess(elephant, Action.READ);
		noAccess(elephant, Action.CREATE);
		noAccess(elephant, Action.UPDATE);
		noAccess(elephant, Action.DELETE);

		SecurityMatrix.grantAccess(elephant, Action.READ, Day.MONDAY);
		assertTrue(SecurityMatrix.hasAccess(elephant, Day.MONDAY, Action.READ));
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.TUESDAY, Action.READ));
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.MONDAY, Action.CREATE));
	}

	@Test
	public void createNewRole_AlreadyExists() throws RoleAlreadyExistsException {
		Role elephant = new Role("ELEPHANT");
		try {
			SecurityMatrix.createRole(elephant);
			fail("Should throw an exception");
		} catch (RoleAlreadyExistsException e) {
			// success
		}
		assertTrue(SecurityMatrix.hasAccess(elephant, Day.MONDAY, Action.READ));
	}

	@Test
	public void findRoles() throws RoleAlreadyExistsException {
		List<Role> roles = SecurityMatrix
				.findRoles(Day.SATURDAY, Action.CREATE);
		assertEquals(1, roles.size());
		assertEquals("ADMIN", roles.get(0).getName());
		Role superAdmin = new Role("A SUPER ADMIN");
		SecurityMatrix.createRole(superAdmin);
		SecurityMatrix.grantAccess(superAdmin, Action.CREATE, Day.values());
		roles = SecurityMatrix.findRoles(Day.SATURDAY, Action.CREATE);
		assertEquals(2, roles.size());
		assertEquals("A SUPER ADMIN", roles.get(0).getName());
		assertEquals("ADMIN", roles.get(1).getName());
	}

	@Test
	public void findDays()throws RoleAlreadyExistsException{
		Role hippo = new Role("HIPPO");
		SecurityMatrix.createRole(hippo);
		noAccess(hippo, Action.READ);
		noAccess(hippo, Action.CREATE);
		noAccess(hippo, Action.UPDATE);
		noAccess(hippo, Action.DELETE);

		SecurityMatrix.grantAccess(hippo, Action.READ, Day.MONDAY);
		SecurityMatrix.grantAccess(hippo, Action.READ, Day.WEDNESDAY);
		List<Day> days = SecurityMatrix.findDays(hippo,Action.READ);
		assertEquals(2, days.size());
		assertTrue(days.contains(Day.MONDAY));
		assertTrue(days.contains(Day.WEDNESDAY));
		assertFalse(days.contains(Day.THURSDAY));
		assertFalse(days.contains(Day.FRIDAY));
		assertFalse(days.contains(Day.SATURDAY));
		assertFalse(days.contains(Day.SUNDAY));
		
		SecurityMatrix.grantAccess(hippo, Action.READ, Day.THURSDAY);
		List<Day> updatedDays = SecurityMatrix.findDays(hippo,Action.READ);
		assertEquals(3, updatedDays.size());
		assertTrue(updatedDays.contains(Day.MONDAY));
		assertTrue(updatedDays.contains(Day.WEDNESDAY));
		assertTrue(updatedDays.contains(Day.THURSDAY));
		assertFalse(updatedDays.contains(Day.FRIDAY));
		assertFalse(updatedDays.contains(Day.SATURDAY));
		assertFalse(updatedDays.contains(Day.SUNDAY));
	}
	@Test
	public void findActions()throws RoleAlreadyExistsException{
		Role frog = new Role("FROG");
		SecurityMatrix.createRole(frog);
		noAccess(frog, Action.READ);
		noAccess(frog, Action.CREATE);
		

		SecurityMatrix.grantAccess(frog, Action.READ, Day.MONDAY);
		SecurityMatrix.grantAccess(frog, Action.CREATE, Day.TUESDAY);
	
		List<Action> actions = SecurityMatrix.findActions(frog,Day.MONDAY);
		assertEquals(1, actions.size());
		assertTrue(actions.contains(Action.READ));
		assertFalse(actions.contains(Action.CREATE));
		assertFalse(actions.contains(Action.UPDATE));
		assertFalse(actions.contains(Action.DELETE));
		
		SecurityMatrix.grantAccess(frog, Action.DELETE, Day.MONDAY);
		List<Action> updatedActions = SecurityMatrix.findActions(frog,Day.MONDAY);
		assertEquals(2, updatedActions.size());
		assertTrue(updatedActions.contains(Action.READ));
		assertFalse(updatedActions.contains(Action.CREATE));
		assertFalse(updatedActions.contains(Action.UPDATE));
		assertTrue(updatedActions.contains(Action.DELETE));
		
	}
	
	private void noAccess(Role elephant, Action action) {
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.MONDAY, action));
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.TUESDAY, action));
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.WEDNESDAY, action));
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.THURSDAY, action));
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.FRIDAY, action));
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.SATURDAY, action));
		assertFalse(SecurityMatrix.hasAccess(elephant, Day.SUNDAY, action));
	}
	


}
