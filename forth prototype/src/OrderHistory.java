
public class OrderHistory {

	private String orderNo;
	private String productCode;
	private Double kitPrice;
	
	
	public OrderHistory(Order order) {
		
		orderNo = order.getOrderNo();
		productCode = order.getProductCode();
		kitPrice = calcKitPrice(order);
	}

	// getter and setter
	public String getOrderNo() {
		return orderNo;
	}


	public String getProductCode() {
		return productCode;
	}


	public Double getKitPrice() {
		return kitPrice;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
		
		return 0;
	}
	
	
	
	
	
	
}
