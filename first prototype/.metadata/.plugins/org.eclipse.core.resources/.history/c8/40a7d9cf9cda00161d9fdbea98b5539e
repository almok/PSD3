
public class BForm {
	
	// fields
	private int orderNo;
	private String chassisType, productCode;
	private float receiptTime, actDelTime, scheDelTime, scheLeadTime, delTime,
		penalty, price, revenue;
	
	// constructors
	public BForm(int orderNo, String chassisType, String productCode, float price, float penalty, float receiptTime,
			float actDelTime, float scheDelTime, float scheLeadTime){
		this(orderNo, chassisType, productCode, price, penalty);
		
		this.receiptTime = receiptTime;
		this.actDelTime = actDelTime;
		this.scheDelTime = scheDelTime;
		this.scheLeadTime = scheLeadTime;
		delTime = scheDelTime - actDelTime;
	}

	public BForm(int orderNo, String chassisType, String productCode, float price, float penalty){
		this(price, penalty);
		
		this.orderNo = orderNo;
		this.chassisType = chassisType;
		this.productCode = productCode;
	}
	
	public BForm(float price, float penalty){
		this.price = price;
		this.penalty = penalty;
		revenue = price - penalty;
	}

	// get methods
	public int getOrderNo(){
		return orderNo;
	}
	
	public String getChassisType(){
		return chassisType;
	}
	
	public String getProductCode(){
		return productCode;
	}
	
	public float getPrice(){
		return price;
	}
	
	public float getPenalty(){
		return penalty;
	}
	
	public float getRevenue(){
		return revenue;
	}
	
	public float getReceiptTime(){
		return receiptTime;
	}
	
	public float getScheDelTime(){
		return scheDelTime;
	}
	
	public float getScheLeadTime(){
		return scheLeadTime;
	}
	
	public float getActDelTime(){
		return actDelTime;
	}
	
	public float getDelTime(){
		return delTime;
	}
}
