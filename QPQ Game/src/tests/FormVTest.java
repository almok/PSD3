package tests;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import forms.FormVcontroller;
import main.PSDSingleton;

public class FormVTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PSDSingleton data = PSDSingleton.getInstance();
		FormVcontroller formV = new FormVcontroller();
	}

	@Test
	public void testDisplayTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveFields() {
		fail("Not yet implemented");
	}

}
