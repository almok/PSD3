package tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import forms.FormTMenu;
import main.PSDSingleton;

public class FormTtest {

	@Before
	public static void init() {
		PSDSingleton data = PSDSingleton.getInstance();
		FormTMenu formT = new FormTMenu();
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
	public void testSaveEmployees() {
		fail("Not yet implemented");
	}

}
