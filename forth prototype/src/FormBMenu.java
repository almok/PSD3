

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
	
	
	
	private ArrayList<String> field1 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field2 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field3 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field4 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field5 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field6 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field7 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field8 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field9 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field10 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field11 = new ArrayList<String>(Collections.nCopies(20, ""));
	
	private ArrayList<Integer> revenues = new ArrayList<Integer>(Collections.nCopies(20, 0));
	
	
	
	private void calculateTimeDif(){
		String timeDif;
	
			int Actual = Integer.parseInt(fieldEight.getText());
			int scheduled = Integer.parseInt(fieldSix.getText());
			timeDif = String.valueOf(Actual - scheduled);
			fieldNine.setText(timeDif);
			saveFields();
		
	}
	
	public String calculateRevenues(){
		int rev = 0;
		int revSum = 0;
		for (int i = 0; i < formCounter - 1; i++) {
			int f7 = this.isInteger(field7.get(i));
			int f8 = this.isInteger(field8.get(i));
			int f6 = this.isInteger(field6.get(i));
			rev = (f7 - 30 * (f8 - f6));
			revSum += rev;
			
			revenues.set(i, rev);
		}
		FormVcontroller.setRevenue(revSum);
		return revSum + "";
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
		System.out.println("field one display :" + field1.get(c));
		fieldOne.setText(field1.get(c));
		fieldTwo.setText(field2.get(c));
		fieldThree.setText(field3.get(c));
		fieldFour.setText(field4.get(c));
		fieldFive.setText(field5.get(c));
		fieldSix.setText(field6.get(c));
		fieldSeven.setText(field7.get(c));
		fieldEight.setText(field8.get(c));
		fieldNine.setText(field9.get(c));
		fieldTen.setText(field10.get(c));
		fieldEleven.setText(field11.get(c));
		
	}
	//save orders
	/*private void saveOrders(int formCounter){
	int c = 0;
	orders.clear();
	for(int i = 0; i < formCounter ; i++){
		Order order = new Order(null, null, null, null, null, null);
		
		order.setContractPrice(field7.get(i));
		orders.add(order);
		c++;
	}
	

	}
	private void displayOrders(){
		int j = 0;
		for(Order order: orders)
		{
			//field1.set(j, order.get);
			//field2.set(j, fieldTwo.getText());
			//field3.set(j, fieldThree.getText());
			//field4.set(j, fieldFour.getText());
			//field5.set(j, fieldFive.getText());
			field6.set(j, order.getScheduleTime());
			field7.set(j, order.getContractPrice());
			field8.set(j, order.getActualTime());
			//field9.set(j, fieldNine.getText());
			//field10.set(j, fieldTen.getText());
			//field11.set(j, fieldEleven.getText());
			j++;
			addFormButtons(leftVBox);
		}
		
	}*/
	private void saveFields(int c){
		field1.set(c, fieldOne.getText());
		field2.set(c, fieldTwo.getText());
		field3.set(c, fieldThree.getText());
		field4.set(c, fieldFour.getText());
		field5.set(c, fieldFive.getText());
		field6.set(c, fieldSix.getText());
		field7.set(c, fieldSeven.getText());
		field8.set(c, fieldEight.getText());
		field9.set(c, fieldNine.getText());
		field10.set(c, fieldTen.getText());
		field11.set(c, fieldEleven.getText());
		
	    
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
				
				currentForm = c;
				displayValues(c -1);
				//saveFields(currentForm - 1);
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
	private  TextField fieldOne;
	@FXML
	private  TextField fieldTwo;
	@FXML
	private  TextField fieldThree;
	@FXML
	private  TextField fieldFour;
	@FXML
	private  TextField fieldFive;
	@FXML
	private  TextField fieldSix;
	@FXML
	private  TextField fieldSeven;
	@FXML
	private  TextField fieldEight;
	@FXML
	private  TextField fieldNine;
	@FXML
	private  TextField fieldTen;
	@FXML
	private  TextField fieldEleven;
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
				field1.set(i, array.get(i)[0]);
				field3.set(i, array.get(i)[1]);
				field7.set(i, array.get(i)[2]);
				field6.set(i, array.get(i)[3]);
				field8.set(i, array.get(i)[4]);
				
				addFormButtons(leftVBox);
			
		}
		
		for(int j = 0; j < orders.size(); j++)
		{
			//System.out.println("Order number is"  + orders.get(j).getOrderNumberAsString());
			//System.out.println("Schedule Time :" + orders.get(j).getScheduleTimeAsString());
			//field1.set(j , orders.get(j).getOrderNumberAsString());
			//field6.set(j, orders.get(j).getScheduleTimeAsString());
			//addFormButtons(leftVBox);
			
		}
		backButton.setOnAction(e -> {
			ArrayList<String[]> formBData = new ArrayList<>();
			//iterate fields creating orders
			for(int i = 0; i < field1.size(); i++)
			{
				Order order = new Order(field1.get(i),field3.get(i) , field7.get(i), field6.get(i),field8.get(i) , null);
				System.out.println(order.getOrderNumber());
				orders.add(order);
			}
		    //iterate orders adding to formB Data
			for(int k = 0; k < orders.size(); k++){
				String orderNum = orders.get(k).getOrderNumber();
				String productCode = orders.get(k).getProductCode();
				String contractPrice = orders.get(k).getContractPrice();
				String scheduleTime = orders.get(k).getScheduleTime();
				String actualTime = orders.get(k).getActualTime();
				if(orderNum != ""){
					String[] _order = new String[5];
					_order[0] = orderNum;
					_order[1] = productCode;
					_order[2] = contractPrice;
					_order[3] = scheduleTime;
					_order[4] = actualTime;
					
					formBData.add(_order);
				}
		}
		System.out.println("field 1 saved  :" + formBData.get(0)[0]);
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
		
		
		
		
		/*fieldEight.textProperty().addListener((observable, oldValue, newValue) -> {
		    saveFields();
		    calculateTimeDif();
		});
		
		fieldOne.textProperty().addListener((observable, oldValue, newValue) -> {
		    saveFields();
		});
		
		fieldSix.textProperty().addListener((observable, oldValue, newValue) -> {
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
				stage.hide();
				stage.setScene(scene);
				stage.show();
				scene.getStylesheets().add("Styling.css");
			}
		
	

	
}
