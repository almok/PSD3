package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import forms.AYNEmployee;

public class AYNEmptest {
	
	private static AYNEmployee emp;

	@BeforeClass
	public static void setUp() {
		emp = new AYNEmployee("", "", false, 1, 2, 1, 0.0, 0);
		
	}

	@Test
	public void testCalcWage() {
		double wage = 15.0 + 75 + 100;
		assertEquals((Double) wage, (Double) emp.calcWage());
		
		wage = 25 + 75 + 100;
		emp.setMultiSkilled(true);
		assertEquals((Double) wage, (Double) emp.calcWage());
		
		// what about hiring and firing costs?
	}

}
