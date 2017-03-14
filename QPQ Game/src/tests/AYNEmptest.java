package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import forms.AYNEmployee;

public class AYNEmptest {
	
	private static AYNEmployee emp;

	@BeforeClass
	public static void setUp() {
		emp = new AYNEmployee("", "", false, 1, 2, 1, 0.0);
		
	}

	@Test
	public void testCalcWage() {
		assertEquals((Double) 15.0, (Double) emp.calcWage());
		
		
		emp.setMultiSkilled(true);
		assertEquals((Double) 25.0, (Double) emp.calcWage());
		
		// what about hiring and firing costs?
	}

}
