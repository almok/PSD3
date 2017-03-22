package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import forms.FormOMenu;
import forms.Order;

public class FormOtest {

	private FormOMenu formO;
	
	@Before
	public void setUp(){
		formO = new FormOMenu();
		formO.updateOrderHistory(new Order(null, "FDR371Y", null, null, null, null, null));
		formO.updateOrderHistory(new Order(null, "pst350y", null, null, null, null, null));
		formO.updateOrderHistory(new Order(null, "aDe350X", null, null, null, null, null));
		formO.updateOrderHistory(new Order(null, "ssT370Y", null, null, null, null, null));
		formO.updateOrderHistory(new Order(null, "CsSB0y", null, null, null, null, null));
		formO.updateOrderHistory(new Order(null, "dddddddddddddd", null, null, null, null, null));
		formO.updateOrderHistory(new Order(null, "", null, null, null, null, null));
	}

	@Test
	public void testCalcTotalKitPrice() {
		
		Double sum = 290.0 + 280.0 + 368.0 + 310.0 + 463.0;
		assertEquals(sum, (Double) formO.calcTotalKitPrice());
		
	}

}
