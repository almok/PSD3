package tests;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import forms.FormOMenu;
import main.PSDSingleton;

public class FormOtest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PSDSingleton data = PSDSingleton.getInstance();
		FormOMenu formO = new FormOMenu();
	}

	@Test
	public void testCalcTotalKitPrice() {
		fail("Not yet implemented");
	}

}
