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
		
		order.setProductCode("pst350y");
		assertEquals((Double) 280.0, (Double) order.calcKitPrice());
		
		order.setProductCode("aDe350X");
		assertEquals((Double) 368.0, (Double) order.calcKitPrice());
		
		order.setProductCode("ssT370Y");
		assertEquals((Double) 310.0, (Double) order.calcKitPrice());
		
		order.setProductCode("CsSB0y");
		assertEquals((Double) 463.0, (Double) order.calcKitPrice());
		
		order.setProductCode("dddddddddddddd");
		double d = -1;
		assertEquals((Double) d, (Double) order.calcKitPrice());
		
		order.setProductCode("");
		assertEquals((Double) d, (Double) order.calcKitPrice());

		// more tests
	}

}
