package tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import forms.FormSMenu;
import main.PSDSingleton;

public class FormStest {

	@Before
	public static void init() {
		PSDSingleton data = PSDSingleton.getInstance();
		FormSMenu formS = new FormSMenu();
	}

	@Test
	public void testCreateNewEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountEmployees() {
		fail("Not yet implemented");
	}

}
