
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
}
