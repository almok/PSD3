package tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import forms.Order;
import forms.OrderHistory;

public class OrderHistorytest {

	@Before
	public void setUp() throws Exception {
		OrderHistory order = new OrderHistory(new Order(null, null, null, null, null, null));		
	}

	@Test
	public void testCalcKitPrice() {
		fail("Not yet implemented");
	}

}
