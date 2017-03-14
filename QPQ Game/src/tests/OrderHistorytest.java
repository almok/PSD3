package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import forms.Order;
import forms.OrderHistory;

public class OrderHistorytest {


	@Test
	public void testCalcKitPrice() {
		OrderHistory order = new OrderHistory(new Order(null, "FDR371Y", null, null, null, null));
		assertEquals((Double) 290.0, (Double) order.getKitPrice());
	}

}
