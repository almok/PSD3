package forms;

public class Order {

	
	private String orderNumber;
	private String productCode;
	private String contractPrice;
	private String scheduleTime;
	private String actualTime;
	private String penalty;
	private int    timeDiff;
	
	public Order(String orderNumber, String productCode, String contractPrice, String scheduleTime, String actualTime, String penalty) {
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.contractPrice = contractPrice;
		this.scheduleTime = scheduleTime;
		this.actualTime = actualTime;
		this.penalty = penalty;
		
	}
	
	
	// getters and setters
	public String getOrderNumber() {
		return orderNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getContractPrice() {
		return contractPrice;
	}


	public void setContractPrice(String contractPrice) {
		this.contractPrice = contractPrice;
	}


	public String getActualTime() {
		return actualTime;
	}


	public void setActualTime(String actualTime) {
		this.actualTime = actualTime;
	}


	public String getPenalty() {
		return penalty;
	}


	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}


	public String getScheduleTime() {
		return scheduleTime;
	}


	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	public int getTimeDiff(){
		return timeDiff;
	}

    public void setTimeDiff(int timeDiff){
    	this.timeDiff = timeDiff;
    }
	
}
