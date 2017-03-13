package forms;

import main.PSDSingleton;

public class OrderHistory {

	private String orderNumber;
	private String productCode;
	private Double kitPrice;
	private String kitPriceString;
	
	
	public OrderHistory(Order order) {
		
		orderNumber = order.getOrderNumber();
		productCode = order.getProductCode();
		kitPrice = calcKitPrice();
		kitPriceString = ((kitPrice == -1) ? "Invalid Product Code" : Double.toString(kitPrice));
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
	
	public String getKitPriceString() {
		return kitPriceString;
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
	
	public void setKitPriceString(String kitPriceString) {
		this.kitPriceString = kitPriceString;
	}
	
	// calculate kit price using product code
	public double calcKitPrice(){
		if (productCode == null || productCode.length() != 6 && productCode.length() != 7){
			return -1;
		}
		String carName;
		String chassis;
		String prodLine;
		char lights;
		char gps;
		
		prodLine = Character.toString(productCode.charAt(0));
		chassis = Character.toString(productCode.charAt(1));
		chassis += Character.toString(productCode.charAt(2));
		
		switch(prodLine){
			case "F": case "f": carName = "Family "; break;
			case "P": case "p": carName = "Pony "; break;
			case "S": case "s": carName = "Sedan "; break;
			case "A": case "a": carName = "Ayrton "; break;
			case "C": case "c": carName = "Coast";  break;
			case "T": case "t": carName = "Thunder"; break;	
			default: return -1;
		}
		
		if (carName == "Coast" || carName == "Thunder"){
			return Double.parseDouble(PSDSingleton.getInstance().getLightsPrice(carName));
		}
		else {
			switch(chassis){
				case "ST": case "st": case "St": case "sT": carName += "Standard"; break;
				case "DE": case "de": case "Dr": case "dT": carName += "Dragstar"; break;
				case "DR": case "dr": case "De": case "dE": carName += "Deluxe"; break;
				default: return -1;
			}
			
			lights = productCode.charAt(6);
			gps = productCode.charAt(5);
		
			if ((lights == 'Y' || lights == 'y') && gps == '1'){
				return Double.parseDouble(PSDSingleton.getInstance().getGPSYellowPrice(carName));
			}
			else if ((lights == 'Y' || lights == 'y') && gps == '0'){
				
				return Double.parseDouble(PSDSingleton.getInstance().getNoGPSYellowPrice(carName));
			}
			else if ((lights == 'X' || lights == 'x') && gps == '1'){
				return Double.parseDouble(PSDSingleton.getInstance().getGPSXenonPrice(carName));
			}
			else if ((lights == 'X' || lights == 'x') && gps == '0'){
				return Double.parseDouble(PSDSingleton.getInstance().getNoGPSXenonPrice(carName));
			}
		}
		return -1;
	}
}
