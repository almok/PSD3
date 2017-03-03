

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.PSDSingleton;

public class FormBMenu implements Initializable{
	//private static Button backButton;
	
	private int formCounter = 1;
	private int currentForm = 1;
	public Scene scene;
	
	
	
	private ArrayList<String> orderArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> chassisArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> productCodeArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> timeOfReceiptArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> leadTimeArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> scheduledDeliveryTimeArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> contractPriceArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> actualDeliveryTimeArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> timeDifferenceArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> penaltyPriceArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> revenueArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	
	private ArrayList<Integer> revenues = new ArrayList<Integer>(Collections.nCopies(20, 0));
	
	
	
	private void calculateTimeDif(){
		String timeDif;
	
			int Actual = Integer.parseInt(actualDeliveryTimeField.getText());
			int scheduled = Integer.parseInt(scheduledDeliveryTimeField.getText());
			timeDif = String.valueOf(Actual - scheduled);
			timeDifferenceLabel.setText(timeDif);
			saveFields();
		
	}
	

	private int isInteger(String s) {
	    try { 
	        return Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return 0; 
	    } catch(NullPointerException e) {
	        return 0;
	    }
	}
	
	private void displayValues(int c){
		System.out.println("displaying values : " + c);
		System.out.println("field one display :" + orderArrayList.get(c));
		orderField.setText(orderArrayList.get(c));
		chassisField.setText(chassisArrayList.get(c));
		productCodeField.setText(productCodeArrayList.get(c));
		timeOfReceiptField.setText(timeOfReceiptArrayList.get(c));
		leadTimeField.setText(leadTimeArrayList.get(c));
		scheduledDeliveryTimeField.setText(scheduledDeliveryTimeArrayList.get(c));
		contractPriceField.setText(contractPriceArrayList.get(c));
		actualDeliveryTimeField.setText(actualDeliveryTimeArrayList.get(c));
		timeDifferenceLabel.setText(timeDifferenceArrayList.get(c));
		
		// working around to get time difference displaying on reopening an order - to be sorted and cleaned up
		if (!scheduledDeliveryTimeArrayList.get(c).equals("") && !actualDeliveryTimeArrayList.get(c).equals("")){
			int sch = Integer.parseInt(scheduledDeliveryTimeArrayList.get(c));
			int act = Integer.parseInt(actualDeliveryTimeArrayList.get(c));
			
			
			timeDifferenceLabel.setText(String.valueOf(act-sch));
		}
		
		penaltyPriceField.setText(penaltyPriceArrayList.get(c));
		revenueField.setText(revenueArrayList.get(c));
		
	}
	//save orders
	/*private void saveOrders(int formCounter){
	int c = 0;
	orders.clear();
	for(int i = 0; i < formCounter ; i++){
		Order order = new Order(null, null, null, null, null, null);
		
		order.setContractPrice(contractPriceArrayList.get(i));
		orders.add(order);
		c++;
	}
	

	}
	private void displayOrders(){
		int j = 0;
		for(Order order: orders)
		{
			//orderArrayList.set(j, order.get);
			//chassisArrayList.set(j, chassisField.getText());
			//productCodeArrayList.set(j, productCodeField.getText());
			//timeOfReceiptArrayList.set(j, timeOfReceiptField.getText());
			//leadTimeArrayList.set(j, leadTimeField.getText());
			scheduledDeliveryTimeArrayList.set(j, order.getScheduleTime());
			contractPriceArrayList.set(j, order.getContractPrice());
			actualDeliveryTimeArrayList.set(j, order.getActualTime());
			//timeDifferenceArrayList.set(j, timeDifferenceLabel.getText());
			//penaltyPriceArrayList.set(j, penaltyPriceField.getText());
			//revenueArrayList.set(j, revenueField.getText());
			j++;
			addFormButtons(leftVBox);
		}
		
	}*/
	private void saveFields(int c){
		orderArrayList.set(c, orderField.getText());
		chassisArrayList.set(c, chassisField.getText());
		productCodeArrayList.set(c, productCodeField.getText());
		timeOfReceiptArrayList.set(c, timeOfReceiptField.getText());
		leadTimeArrayList.set(c, leadTimeField.getText());
		scheduledDeliveryTimeArrayList.set(c, scheduledDeliveryTimeField.getText());
		contractPriceArrayList.set(c, contractPriceField.getText());
		actualDeliveryTimeArrayList.set(c, actualDeliveryTimeField.getText());
		timeDifferenceArrayList.set(c, timeDifferenceLabel.getText());
		penaltyPriceArrayList.set(c, penaltyPriceField.getText());
		revenueArrayList.set(c, revenueField.getText());
		
	    
	}
	
	private void saveFields(){
		int c = currentForm - 1;
		saveFields(c);
	}
	
	private void addFormButtons(VBox left){
		int c = formCounter;
		if(formCounter == 1){
			Button formButton = new Button(" Order " + formCounter + " ");
			formCounter++;
			left.getChildren().add(formButton);
            formButton.setOnAction(e -> {
				
				System.out.println("current form is :" + currentForm);
				//System.out.println("values in field 1 :" + );
				currentForm = c;
				displayValues(c -1);
				saveFields(currentForm - 1);
			});
		}
		else if (formCounter > 1 && formCounter < 10){ 
			Button formButton = new Button(" Order " + formCounter + " ");
			//Order order = new Order(Integer.toString(c), null, null, null, null, null);
			formCounter++;
			left.getChildren().add(formButton);
			formButton.setOnAction(e -> {
				
				System.out.println("current form is :" + currentForm);
				saveFields(currentForm - 1);
				currentForm = c;
				displayValues(c -1);
			});
		} else if (formCounter >= 10 && formCounter <= 20){ 
			Button formButton = new Button("Order " + formCounter);
			//Order order = new Order(Integer.toString(c), null, null, null, null, null);
			formCounter++;
			left.getChildren().add(formButton);
			formButton.setOnAction(e -> {
				
				saveFields(currentForm - 1);
				currentForm = c;
				displayValues(c -1);
			});
		}
	}

	


	@FXML
	private Button backButton;
	@FXML
	private Button newButton;
	@FXML
	private VBox leftVBox;
	@FXML
	private  TextField orderField;
	@FXML
	private  TextField chassisField;
	@FXML
	private  TextField productCodeField;
	@FXML
	private  TextField timeOfReceiptField;
	@FXML
	private  TextField leadTimeField;
	@FXML
	private  TextField scheduledDeliveryTimeField;
	@FXML
	private  TextField contractPriceField;
	@FXML
	private  TextField actualDeliveryTimeField;
	@FXML
	private  Label timeDifferenceLabel;
	@FXML
	private  TextField penaltyPriceField;
	@FXML
	private  TextField revenueField;
	@FXML
	private static Button form1;
	@FXML
	private static Button form2;
	@FXML
	private static Button form3;
	
	ObservableList<Order> orders = FXCollections.observableArrayList();
	/*public void createNewOrder(){
		
		Order order = new Order(null, null, null, null, null, null);
		orders.add(order);
		saveFields();
		addFormButtons(leftVBox);
	}*/
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//if there is data in forms simulate adding new order
		
		ArrayList<String []> array = PSDSingleton.getInstance().getFormBData();
		System.out.println(array.size());
		
		for (int i = 0; i < array.size() ; i ++){
			
				System.out.println("i is " + i);
				if(array.get(i)[0].isEmpty() != true)
				{
				System.out.println("order number is :" + array.get(i)[0]);
				orderArrayList.set(i, array.get(i)[0]);
				}
				if(array.get(i)[1].isEmpty() != true)
				{
				productCodeArrayList.set(i, array.get(i)[1]);
				}
				if(array.get(i)[2].isEmpty() != true)
				{
				contractPriceArrayList.set(i, array.get(i)[2]);
				}
				if(array.get(i)[3].isEmpty() != true)
				{
				scheduledDeliveryTimeArrayList.set(i, array.get(i)[3]);
				}
				if(array.get(i)[4].isEmpty() != true)
				{
				actualDeliveryTimeArrayList.set(i, array.get(i)[4]);
				}
				
				if(array.get(i)[3].isEmpty() != true && array.get(i)[4].isEmpty() != true){
				
					
					int sch = (Integer.parseInt(array.get(i)[3]));
				    int act = (Integer.parseInt(array.get(i)[4]));
				
				
			    int timeDiff = act - sch;
				
			    
				timeDifferenceArrayList.set(i,String.valueOf(timeDiff));
				}
				addFormButtons(leftVBox);
			
		}
		
		for(int j = 0; j < orders.size(); j++)
		{
			//System.out.println("Order number is"  + orders.get(j).getOrderNumberAsString());
			//System.out.println("Schedule Time :" + orders.get(j).getScheduleTimeAsString());
			//orderArrayList.set(j , orders.get(j).getOrderNumberAsString());
			//scheduledDeliveryTimeArrayList.set(j, orders.get(j).getScheduleTimeAsString());
			//addFormButtons(leftVBox);
			
		}
		backButton.setOnAction(e -> {
			ArrayList<String[]> formBData = new ArrayList<>();
			//iterate fields creating orders
			for(int i = 0; i < orderArrayList.size(); i++)
			{
				Order order = new Order(orderArrayList.get(i),productCodeArrayList.get(i) , contractPriceArrayList.get(i), scheduledDeliveryTimeArrayList.get(i),actualDeliveryTimeArrayList.get(i) , null);
				System.out.println(order.getOrderNumber());
				orders.add(order);
			}
		    //iterate orders adding to formB Data
			for(int k = 0; k < orders.size(); k++){
				String orderNum = orders.get(k).getOrderNumber();
				System.out.println("order number saved :" + orderNum);
				String productCode = orders.get(k).getProductCode();
				String contractPrice = orders.get(k).getContractPrice();
				String scheduleTime = orders.get(k).getScheduleTime();
				String actualTime = orders.get(k).getActualTime();
				String penalty = orders.get(k).getPenalty();
				if(orderNum != ""){
					String[] _order = new String[6];
					_order[0] = orderNum;
					_order[1] = productCode;
					_order[2] = contractPrice;
					_order[3] = scheduleTime;
					_order[4] = actualTime;
					_order[5] = penalty;
					
					
					formBData.add(_order);
				}
		}
		//System.out.println("field 1 saved  :" + formBData.get(0)[0]);
		PSDSingleton.getInstance().setFormBData(formBData);
		
		
		
					FormVcontroller formV = new FormVcontroller();
			
			
			try{
				formV.display(backButton);
			}catch(IOException e1){
				e1.printStackTrace();
			}
		});
		
		//re-populate forms
		//displayOrders();		
		
		
		
		
		/*actualDeliveryTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
		    saveFields();
		    calculateTimeDif();
		});
		
		orderField.textProperty().addListener((observable, oldValue, newValue) -> {
		    saveFields();
		});
		
		scheduledDeliveryTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
		    saveFields();
		});
		*/
		newButton.setOnAction(event -> {
			saveFields();
			addFormButtons(leftVBox);
        });
	
	}
	
	

			// display this form
			public void display(Button button) throws IOException{
				
				Parent parent = FXMLLoader.load(getClass().getResource("formB.fxml"));
				Scene scene = new Scene(parent);
				Stage stage = (Stage) button.getScene().getWindow();
				scene.getStylesheets().add("Styling.css");
				stage.setScene(scene);
				
			}
		
	

	
}