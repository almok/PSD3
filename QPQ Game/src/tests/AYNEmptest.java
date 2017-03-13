package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import forms.AYNEmployee;
import main.PSDSingleton;

public class AYNEmptest {

	@Before
	public void setUp() {
		PSDSingleton data = PSDSingleton.getInstance();
		AYNEmployee emp = new AYNEmployee();
	}

	@Test
	public void testCalcWage() {
		fail("Not yet implemented");
	}

}
