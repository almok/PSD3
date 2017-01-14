
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
		
		this.receiptTime = receiptTime;		// Time of receipt of order (as appears on B-Form)
		this.actDelTime = actDelTime;		// Actual Delivery time
		this.scheDelTime = scheDelTime;		// Scheduled Delivery time
		this.scheLeadTime = scheLeadTime;	// Scheduled Lead time (d)
		delTime = scheDelTime - actDelTime;	// Scheduled and Actual time difference
	}

	public BForm(int orderNo, String chassisType, String productCode, float price, float penalty){
		this(price, penalty);
		
		this.orderNo = orderNo;				// Order Number
		this.chassisType = chassisType;		// Chassis Type
		this.productCode = productCode;		// Product Code (c)
	}
	
	public BForm(float price, float penalty){
		this.price = price;					// Contract Price (a)
		this.penalty = penalty;				// Penalty (b)
		revenue = price - penalty;			// Revenue (a - b)
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
	
	// used for output
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