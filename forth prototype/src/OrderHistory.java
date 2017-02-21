
public class OrderHistory {

	private String orderNumber;
	private String productCode;
	private Double kitPrice;
	
	
	public OrderHistory(Order order) {
		
		orderNumber = order.getOrderNumber();
		productCode = order.getProductCode();
		kitPrice = calcKitPrice(order);
	}

	// getter and setter
	public String getOrderNumber() {
		return orderNumber;
	}


	public String getProductCode() {
		return productCode;
	}


	public Double getKitPrice() {
		return kitPrice;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public void setKitPrice(Double kitPrice) {
		this.kitPrice = kitPrice;
	}
	
	// calculate kit price using product code
	public double calcKitPrice(Order order){
		
		// todo
		
		return 3;
	}
	
	
	
	
	
	
}
