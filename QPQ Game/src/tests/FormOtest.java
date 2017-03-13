package tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import forms.FormOMenu;
import main.PSDSingleton;

public class FormOtest {

	@Before
	public static void init() throws Exception {
		PSDSingleton data = PSDSingleton.getInstance();
		FormOMenu formO = new FormOMenu();
	}

	@Test
	public void testCalcTotalKitPrice() {
		fail("Not yet implemented");
	}

}
