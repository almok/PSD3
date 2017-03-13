package tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import forms.FormBMenu;
import main.PSDSingleton;

public class FormBTest {

	@Before
	public static void init() {
		FormBMenu formB = new FormBMenu();
		PSDSingleton data = PSDSingleton.getInstance();
		
	}

	@Test
	public void testSaveOrders() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCreateNewOrder() {
		fail("Not yet implemented");
	}

}
