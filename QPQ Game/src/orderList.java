import javafx.scene.control.TextField;

public class orderList {
	private TextField OrderNum;
	private TextField chassisType;
	private TextField productCode;
	private TextField reciept;
	private TextField leadTime;
	private TextField scheduleTime;
	private TextField contractPrice;
	private TextField deliveryTime;
	private TextField difference;
	private TextField penalty;
	private TextField revenue;
	
	
	
	//constructor
	public orderList(Order order ){
		
		OrderNum = new TextField();
	    chassisType = new TextField();
	    productCode = new TextField();
	    reciept = new TextField();
	    leadTime = new TextField();
	    scheduleTime= new TextField();
	    contractPrice= new TextField();
	    deliveryTime = new TextField();
	    difference = new TextField();
	    penalty = new TextField();
	    revenue = new TextField();
	    
	    
	    OrderNum.textProperty().addListener((observable, oldValue, newValue) -> {order.setOrderNumber(newValue);});
	    scheduleTime.textProperty().addListener((observable, oldValue, newValue) -> {order.setScheduleTime(newValue);});
	    contractPrice.textProperty().addListener((observable, oldValue, newValue) -> {order.setContractPrice(newValue);});
	    deliveryTime.textProperty().addListener((observable, oldValue, newValue) -> {order.setActualTime(newValue);});
	}
	
	public orderList(Order order, String OrderNo, String schedTime){
		OrderNum = new TextField(OrderNo);
		scheduleTime = new TextField(schedTime);
		OrderNum.textProperty().addListener((observable, oldValue, newValue) -> {order.setOrderNumber(newValue);});
		scheduleTime.textProperty().addListener((observable, oldValue, newValue) -> {order.setScheduleTime(newValue);});
	}
	public TextField getOrderNumber(){
		return OrderNum;
	}
	public String getOrderNumberAsString(){
		return OrderNum.getText();
	}
	public void setOrderNumber(String OrderNum){
		this.OrderNum.setText(OrderNum);
	}
	public TextField getScheduleTime(){
		return scheduleTime;
	}
	public String getScheduleTimeAsString(){
		return scheduleTime.getText();
	}
	public void setScheduleTime(String schedTime)
	{
		this.scheduleTime.setText(schedTime);
	}
	
}
