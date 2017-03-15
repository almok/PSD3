package forms;

public class Order {

	
	private String orderNumber;
	private String productCode;
	private String contractPrice;
	private String scheduleTime;
	private String actualTime;
	private String penalty;
	private String scheLeadTime;
	private String receiptTime;
	private int    timeDiff;
	
	public Order(String orderNumber, String productCode, String contractPrice, String scheduleTime, String actualTime, String penalty) {
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.contractPrice = contractPrice;
		this.scheduleTime = scheduleTime;
		this.actualTime = actualTime;
		this.penalty = penalty;
		
	}
	
	// checks if a productcode is valid
	public static boolean isCodeValid (String prodCode){
		if (prodCode.length() != 6 && prodCode.length() != 7){
			return false;
		}
		
		String chassis;
		String prodLine;
		boolean special;
		
		prodLine = Character.toString(prodCode.charAt(0));
		chassis = Character.toString(prodCode.charAt(1));
		chassis += Character.toString(prodCode.charAt(2));
		
		switch(prodLine){
			case "F": case "f": special = false; break;
			case "P": case "p": special = false; break;
			case "S": case "s": special = false; break;
			case "A": case "a": special = false; break;
			case "C": case "c": special = true; break;
			case "T": case "t": special = true; break;	
			default: return false;
		}
				
		switch(chassis){
			case "ST": case "st": case "St": case "sT": break;
			case "DR": case "dr": case "Dr": case "dR": break;
			case "DE": case "de": case "De": case "dE": break;
			case "SS": case "ss": case "Ss": case "sS": break;
			default: return false;
		}
		if (prodCode.length() == 6){
			if (special && (prodCode.charAt(3) == 'B' || prodCode.charAt(3) == 'b') && prodCode.charAt(4) == '0' && (prodCode.charAt(5) == 'y' || prodCode.charAt(5) == 'y')){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			switch(prodCode.charAt(3)){
				case '2': case '3': case '4': break;
				default: return false;
			}
			
			switch(prodCode.charAt(4)){
				case '5': case '6': case '7': break;
				default: return false;
			}
			
			switch(prodCode.charAt(5)){
				case '0': case '1': break;
				default: return false;
			}
			
			switch(prodCode.charAt(6)){
				case 'Y': case 'y': case 'X': case 'x': break;
				default: return false;
			}
		}
		
		return true;
		
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
	public String getScheLeadTime() {
		return scheLeadTime;
	}
	public String getReceiptTime() {
		return receiptTime;
	}
	
	public void setScheLeadTime(String scheLeadTime) {
		this.scheLeadTime = scheLeadTime;
	}
	public void setReceiptTime(String receiptTime) {
		this.receiptTime = receiptTime;
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
