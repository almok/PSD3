package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import forms.Order;
import forms.OrderHistory;

public class OrderHistorytest {
	
	private OrderHistory order;
	
	@Before
	public void setUp() {
		order = new OrderHistory(new Order(null, "FDR371Y", null, null, null, null));}


	@Test
	public void testCalcKitPrice() {
		assertEquals((Double) 290.0, (Double) order.getKitPrice());
		
		// more tests
	}

}
