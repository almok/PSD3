
public class Order {

	
	private String orderNo;
	private String productCode;
	
	
	public Order(String orderNo, String productCode) {
		this.orderNo = orderNo;
		this.productCode = productCode;
	}
	
	
	// getters and setters
	public String getOrderNo() {
		return orderNo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	
}
