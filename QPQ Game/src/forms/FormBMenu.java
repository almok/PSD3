package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.PSDSingleton;
import main.RoundCounter;

public class FormBMenu implements Initializable {
	RoundCounter roundCounter = RoundCounter.getInstance();
	int roundCount = roundCounter.getRoundCounter();

	private static FormBMenu instance = null;
	
	public static FormBMenu getInstance() {
		if(instance == null) {
			instance = new FormBMenu();
	    }
		return instance;
	}
	
	int numOrders = PSDSingleton.getInstance().getNumberOfOrders();
	
	private ArrayList<Integer> formCountList = new ArrayList<Integer>(Collections.nCopies(numOrders, 0));
	
	private int counter;
	private int formCounter = formCountList.get(roundCount);
	private int currentForm = formCountList.get(roundCount);
	public Scene scene;
	


	private ArrayList<String> orderArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> chassisArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> productCodeArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> timeOfReceiptArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> leadTimeArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> scheduledDeliveryTimeArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> contractPriceArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> actualDeliveryTimeArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> timeDifferenceArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> penaltyPriceArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<String> revenueArrayList = new ArrayList<String>(Collections.nCopies(numOrders, ""));
	private ArrayList<Integer> roundCountArray = new ArrayList<Integer>(Collections.nCopies(numOrders, 0));
	private ArrayList<String> fulfilledOrderArray = new ArrayList<String>(Collections.nCopies(numOrders, "False"));
	
	private void displayValues(int c) {
		
		System.out.println("displaying values for order " + c);

		orderField.setText(orderArrayList.get(c));
		chassisField.setText(chassisArrayList.get(c));
		productCodeField.setText(productCodeArrayList.get(c));
		timeOfReceiptField.setText(timeOfReceiptArrayList.get(c));
		leadTimeField.setText(leadTimeArrayList.get(c));
		scheduledDeliveryTimeField.setText(scheduledDeliveryTimeArrayList.get(c));
		contractPriceField.setText(contractPriceArrayList.get(c));
		actualDeliveryTimeField.setText(actualDeliveryTimeArrayList.get(c));
		timeDifferenceLabel.setText(timeDifferenceArrayList.get(c));
		if (fulfilledOrderArray.get(c).equals("Yes")){
			fulfilledOrderDrop.getSelectionModel().select(0);
		}
		else{
			fulfilledOrderDrop.getSelectionModel().select(1);
		}
		// working around to get time difference displaying on reopening an
		// order - to be sorted and cleaned up
		if (!scheduledDeliveryTimeArrayList.get(c).equals("") && !actualDeliveryTimeArrayList.get(c).equals("")) {
			int sch = Integer.parseInt(scheduledDeliveryTimeArrayList.get(c));
			int act = Integer.parseInt(actualDeliveryTimeArrayList.get(c));

			timeDifferenceLabel.setText(String.valueOf(act - sch));
		}
		
		penaltyPriceField.setText(penaltyPriceArrayList.get(c));
		revenueField.setText(revenueArrayList.get(c));

	}

	private void saveFields(int c) {
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
		roundCountArray.set(c, roundCount);
		fulfilledOrderArray.set(c, fulfilledOrderDrop
				.getSelectionModel().getSelectedItem().toString());
	}

	private void saveFields() {
		int c = currentForm - 1;
		if (c != -1){
			saveFields(c);
		}
		
	}

	public void addFormButtons(VBox left) {
		
		left.setSpacing(10);

		if (formCounter == 0) {
			formCounter++;
			currentForm = formCounter; // 1
			Button formButton1 = new Button(" Order " + formCounter + " ");
			
			formButton1.setMaxWidth(99);
			formButton1.setMinWidth(99);
			formButton1.setMaxHeight(25);
			formButton1.setMinHeight(25);
			

			left.getChildren().add(formButton1);

			centerVBox.setVisible(true);

			// buttons action
			formButton1.setOnAction(e -> {
				System.out.println("current form is " + currentForm + " about to be decremented");
				saveFields(currentForm - 1);
				String[] orderTextList = formButton1.getText().split(" ");
				currentForm = Integer.parseInt(orderTextList[orderTextList.length-1]);
				System.out.println("order number is " + currentForm);
				
				displayValues(currentForm - 1);
				
				if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
						&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

					int revenue = 0;
					int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
					int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());

					int timeDiff = actualTime - schedTime;
					timeDifferenceLabel.setText(Integer.toString(timeDiff));
					int penalty = 0;
					if (timeDiff > 0){
						penalty = PSDSingleton.getInstance().getPenalty() * (timeDiff);
						penaltyPriceField.setText(Integer.toString(penalty));
					}
					else{
						penaltyPriceField.setText(Integer.toString(penalty));
					}
					revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
					revenueField.setText(Integer.toString(revenue));
				}
				
				
			});
		} else if (formCounter >= 1 && formCounter < PSDSingleton.getInstance().getNumberOfOrders()) {
			System.out.println("current form is " + currentForm + " about to be decremented");
			centerVBox.setVisible(true);
			formCounter++;
			Button formButton = new Button(" Order " + formCounter + " ");
			
			formButton.setMaxWidth(99);
			formButton.setMinWidth(99);
			formButton.setMaxHeight(25);
			formButton.setMinHeight(25);
			
			left.getChildren().add(formButton);
			
			formButton.setOnAction(e -> {
				System.out.println("clicking on button " + formCounter);
				saveFields(currentForm - 1);
				String[] orderTextList = formButton.getText().split(" ");
				currentForm = Integer.parseInt(orderTextList[orderTextList.length-1]);
				System.out.println("order number is " + currentForm);
				
				displayValues(currentForm - 1);
				
				if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
						&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

					int revenue = 0;
					int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
					int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());
					int timeDiff = actualTime - schedTime;
					timeDifferenceLabel.setText(Integer.toString(timeDiff));
					int penalty = 0;
					if (timeDiff > 0){
						penalty = PSDSingleton.getInstance().getPenalty() * (timeDiff);
						penaltyPriceField.setText(Integer.toString(penalty));
					}
					else{
						penaltyPriceField.setText(Integer.toString(penalty));
					}
					revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
					revenueField.setText(Integer.toString(revenue));
				}
			});
		}
		formCountList.set(roundCount,formCounter);
	}

	@FXML
	private ScrollPane scr;
	@FXML
	private Button backButton;
	@FXML
	private Button newButton;
	@FXML
	private Button deleteButton;
	@FXML
	private VBox leftVBox, centerVBox, buttonsBox;
	@FXML
	private TextField orderField;
	@FXML
	private TextField chassisField;
	@FXML
	private TextField productCodeField;
	@FXML
	private TextField timeOfReceiptField;
	@FXML
	private TextField leadTimeField;
	@FXML
	private TextField scheduledDeliveryTimeField;
	@FXML
	private TextField contractPriceField;
	@FXML
	private TextField actualDeliveryTimeField;
	@FXML
	private Label timeDifferenceLabel;
	@FXML
	private TextField penaltyPriceField;
	@FXML
	private TextField revenueField;
	@FXML
	private ComboBox<String> fulfilledOrderDrop;
	@FXML
	private static Button form1;
	@FXML
	private static Button form2;
	@FXML
	private static Button form3;

	ObservableList<Order> orders = FXCollections.observableArrayList();

	public void createNewOrder() {

		Order order = new Order(null, null, null, null, null, null, "False");
		orders.add(order);
		saveFields();
		addFormButtons(buttonsBox);
	}

	// save order objects to observable list
	private void saveOrders(int forms) {
		orders.clear();
		for (int i = 0; i < forms; i++) {
			// creates new order
			Order order = new Order(null, null, null, null, null, null, "False");

			// gets order details and sets
			order.setContractPrice(contractPriceArrayList.get(i));
			order.setOrderNumber(orderArrayList.get(i));
			order.setScheduleTime(scheduledDeliveryTimeArrayList.get(i));
			order.setActualTime(actualDeliveryTimeArrayList.get(i));
			order.setProductCode(productCodeArrayList.get(i));
			order.setPenalty(penaltyPriceArrayList.get(i));
			order.setScheLeadTime(leadTimeArrayList.get(i));
			order.setReceiptTime(timeOfReceiptArrayList.get(i));
			order.setFulfilledOrder(fulfilledOrderArray.get(i));
			System.out.println("order saved");
			// adds order to list
			orders.add(order);
			
		}
	}

	private void deleteOrder() {
		
		saveFields();
		saveOrders(formCounter);
	
		//System.out.println("form B data order number:"+formBData.get(j)[0]);
		System.out.println("order arraylist order number " + orderArrayList.get(currentForm - 1));
		
		// remove entries from arrayList
		orderArrayList.remove(currentForm -1);
		chassisArrayList.remove(currentForm - 1);
		productCodeArrayList.remove(currentForm-1);
		timeOfReceiptArrayList.remove(currentForm-1);
		leadTimeArrayList.remove(currentForm-1);
		scheduledDeliveryTimeArrayList.remove(currentForm-1);
		contractPriceArrayList.remove(currentForm-1);
		actualDeliveryTimeArrayList.remove(currentForm-1);
		timeDifferenceArrayList.remove(currentForm-1);
		penaltyPriceArrayList.remove(currentForm-1);
		revenueArrayList.remove(currentForm-1);
		roundCountArray.remove(currentForm-1);
		fulfilledOrderArray.remove(currentForm-1);


		formCounter--;

		// remove order button //Point of bug
		//ArrayList<String[]> formBData = new ArrayList<>();

		// saves orders

		saveOrders(formCounter);
		
		// iterate orders adding to formB Data
		for (int k = 0; k < orders.size(); k++) {
			// add buttons
			counter = k;
			System.out.println("loop k "+k);
			Button formButton = new Button(" Order " + (counter + 1) + " ");
			buttonsBox.getChildren().add(formButton);
			formButton.setOnAction(e -> {
				currentForm = counter + 1;
				displayValues(counter);
			});

		}
			
		//ArrayList<String[]> formBData = new ArrayList<>();
		ArrayList<String[]> formBData = PSDSingleton.getInstance().getFormBData();
		
		for (int i = formBData.size() -1 ; i >= 0; i--){
			if (Integer.parseInt(formBData.get(i)[8]) == roundCount){
				formBData.remove(i);
			}
		}

		// iterate orders adding to formB Data
		for (int k = 0; k < orders.size(); k++) {
			String orderNum = orders.get(k).getOrderNumber();
			String productCode = orders.get(k).getProductCode();
			String contractPrice = orders.get(k).getContractPrice();
			String scheduleTime = orders.get(k).getScheduleTime();
			String actualTime = orders.get(k).getActualTime();
			String penalty = orders.get(k).getPenalty();
			String scheLeadTime = orders.get(k).getScheLeadTime();
			String receiptTime = orders.get(k).getReceiptTime();
			String fulfilledOrder = orders.get(k).getFulfilledOrder();
			
			String[] _order = new String[10];
			_order[0] = orderNum;
			_order[1] = productCode;
			_order[2] = contractPrice;
			_order[3] = scheduleTime;
			_order[4] = actualTime;
			_order[5] = penalty;
			_order[6] = scheLeadTime;
			_order[7] = receiptTime;
			_order[8] = String.valueOf(roundCount);
			_order[9] = fulfilledOrder;


			formBData.add(_order);
		}

		PSDSingleton.getInstance().setFormBData(formBData);
		

		// refresh page
		try {
			display(deleteButton);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private boolean isInputValid(int formNo) {
		String errorMessage = "";

		if (orderField.getText() == null || orderField.getText().length() == 0) {
			errorMessage += "No valid Order Number.\n";
		} 
		else {
			
			
			try {
				int ord = Integer.parseInt(orderField.getText());
				System.out.println("--------------------->" + ord);
				for (int i = 0; i < formNo - 1; i++){
					System.out.println("+++++++++++>>>>>" + Integer.parseInt(orderArrayList.get(i)));
					if (ord == Integer.parseInt(orderArrayList.get(i))){
						errorMessage += "Order numbers needs to be unique\n";
						break;
					}
				}
				
			} catch (NumberFormatException e) {
				errorMessage += "No valid Order Number(must be an integer)\n";
			}
		}
		if (chassisField.getText() == null || chassisField.getText().length() == 0) {
			errorMessage += "No valid Product Code.\n";
		}
		if (scheduledDeliveryTimeField.getText() == null || scheduledDeliveryTimeField.getText().length() == 0) {
			errorMessage += "No valid Scheduled delivery time.\n";
		} else {
			try {
				Integer.parseInt(scheduledDeliveryTimeField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid scheduled delivery time (must be an integer)\n";
			}
		}
		if (actualDeliveryTimeField.getText() == null || actualDeliveryTimeField.getText().length() == 0) {
			errorMessage += "No valid Actual Delivery time.\n";
		} else {
			try {
				Integer.parseInt(actualDeliveryTimeField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid Actual Delivery time(must be an integer)\n";
			}
		}
		
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error in Order Form: Order " + Integer.toString(formNo));
			alert.setHeaderText("Error, invalid input");
			alert.setContentText(errorMessage);

			alert.showAndWait();
			return false;
		}

	}
	
	boolean contains(ArrayList<String[]> formBData, String orderNum){
		for (int i = 0; i < formBData.size(); i++){
			if (formBData.get(i)[0].equals(orderNum) && Integer.parseInt(formBData.get(i)[8]) == roundCount){
				return true;
			}
		}
		return false;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		scr.setStyle("-fx-background: #363738;");

		// if there is data in forms simulate adding new order

		ArrayList<String[]> array = PSDSingleton.getInstance().getFormBData();
		System.out.println("orders size" + array.size());
		for (int i = 0; i < array.size(); i++) {

			if (Integer.parseInt(array.get(i)[8]) == roundCount){
				if (array.get(i)[0].isEmpty() != true) {
					orderArrayList.set(formCounter, array.get(i)[0]);

				}
				if (array.get(i)[1].isEmpty() != true) {
					productCodeArrayList.set(formCounter, array.get(i)[1]);
				}
				if (array.get(i)[2].isEmpty() != true) {
					contractPriceArrayList.set(formCounter, array.get(i)[2]);
				}
				if (array.get(i)[3].isEmpty() != true) {
					scheduledDeliveryTimeArrayList.set(formCounter, array.get(i)[3]);
				}
				if (array.get(i)[4].isEmpty() != true) {
					actualDeliveryTimeArrayList.set(formCounter, array.get(i)[4]);
				}
				if (array.get(i)[5].isEmpty() != true) {
					penaltyPriceArrayList.set(formCounter, array.get(i)[5]);
				}
					
				if (array.get(i)[6].isEmpty() != true) {
					leadTimeArrayList.set(formCounter, array.get(i)[6]);
				}
						
				if (array.get(i)[7].isEmpty() != true) {
					timeOfReceiptArrayList.set(formCounter, array.get(i)[7]);
				}
				
				if (array.get(i)[3].isEmpty() != true && array.get(i)[4].isEmpty() != true) {

					int sch = (Integer.parseInt(array.get(i)[3]));
					int act = (Integer.parseInt(array.get(i)[4]));

					int timeDiff = act - sch;

					timeDifferenceArrayList.set(formCounter, String.valueOf(timeDiff));
				}
				if (array.get(i)[9].isEmpty() != true){
					fulfilledOrderArray.set(formCounter, array.get(i)[9]);
				}
				
				addFormButtons(buttonsBox);
			}
		}

		if (formCountList.get(roundCount) != 0) {
			currentForm = formCountList.get(roundCount);
			formCounter = currentForm;
		}
		if (currentForm != 0) {
			displayValues(currentForm - 1);
		} else {
			displayValues(0);
		}
		
		// automatically add chassis
		if (Order.isCodeValid(productCodeField.getText())) {
			if (scheduledDeliveryTimeField.getText() == "") {
				contractPriceField.setText("0");
			} else {
				String carName = getCarName();
				getContPrice(carName, scheduledDeliveryTimeField.getText());
			}
		} else {
			contractPriceField.setText("0");
		}
		
		// automatically add penalty and revenue and contract price
		if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
				&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

			try {
				int penalty = 0;
				int revenue = 0;
				int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
				int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());
				int timeDiff = actualTime - schedTime;

				if (timeDiff > 0){
					penalty = PSDSingleton.getInstance().getPenalty() * (timeDiff);
					penaltyPriceField.setText(Integer.toString(penalty));
				}
				
				penaltyPriceField.setText(Integer.toString(penalty));
				revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
				revenueField.setText(Integer.toString(revenue));
			} catch (Exception e) {
				System.out.println("entered actual delivery time is not a number");
			}
		}

		backButton.setOnAction(e -> {
			
			saveFields();
			boolean toSave = true;
			for (int i = 1; i <= formCounter; i++){
				displayValues(i-1);
				currentForm = i;
				if (!isInputValid(i)){
					toSave = false;
					break;
				}
			}
			if (toSave){  //if (isInputValid()) {
				saveOrders(formCounter);
				System.out.println(orders);

				//ArrayList<String[]> formBData = new ArrayList<>();
				ArrayList<String[]> formBData = PSDSingleton.getInstance().getFormBData();
				
				// remove potential duplicates
				for (int i = formBData.size() -1 ; i >= 0; i--){
					if (Integer.parseInt(formBData.get(i)[8]) == roundCount){
						formBData.remove(i);
					}
				}

				// iterate orders adding to formB Data
				for (int k = 0; k < orders.size(); k++) {
					String orderNum = orders.get(k).getOrderNumber();
					String productCode = orders.get(k).getProductCode();
					String contractPrice = orders.get(k).getContractPrice();
					String scheduleTime = orders.get(k).getScheduleTime();
					String actualTime = orders.get(k).getActualTime();
					String penalty = orders.get(k).getPenalty();
					String scheLeadTime = orders.get(k).getScheLeadTime();
					String receiptTime = orders.get(k).getReceiptTime();
					String fulfilledOrder = orders.get(k).getFulfilledOrder();
					
					String[] _order = new String[10];
					_order[0] = orderNum;
					_order[1] = productCode;
					_order[2] = contractPrice;
					_order[3] = scheduleTime;
					_order[4] = actualTime;
					_order[5] = penalty;
					_order[6] = scheLeadTime;
					_order[7] = receiptTime;
					_order[8] = String.valueOf(roundCount);
					_order[9] = fulfilledOrder;

					formBData.add(_order);
				}

				PSDSingleton.getInstance().setFormBData(formBData);

				FormVcontroller formV = FormVcontroller.getInstance();	

				try {
					formV.display(backButton);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}   
		});


		actualDeliveryTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
					&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

				try {
					int penalty = 0;
					int revenue = 0;
					int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
					int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());

					int timeDiff = actualTime - schedTime;
					timeDifferenceLabel.setText(Integer.toString(timeDiff));
				
					if (timeDiff > 0){
						penalty = PSDSingleton.getInstance().getPenalty() * (timeDiff);
						penaltyPriceField.setText(Integer.toString(penalty));
					}
					else{
						penaltyPriceField.setText(Integer.toString(penalty));
					}
					revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
					revenueField.setText(Integer.toString(revenue));
				} catch (Exception e) {
					System.out.println("entered actual delivery time is not a number");
				}
			}
		});

		// add change listener to scheduled time to calculate contract price
		// immediately
		leadTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (Order.isCodeValid(productCodeField.getText())) {
				if (leadTimeField.getText() == "") {
					contractPriceField.setText("0");
				} else {
					String carName = getCarName();
					getContPrice(carName, leadTimeField.getText());
				}
			} else {
				contractPriceField.setText("0");
			}
			if (!leadTimeField.getText().equals("") && !timeOfReceiptField.getText().equals("")){
				int leadTime = Integer.parseInt(leadTimeField.getText());
				int timeReceipt = Integer.parseInt(timeOfReceiptField.getText());
				String scheduledTime = String.valueOf(leadTime + timeReceipt);
				scheduledDeliveryTimeField.setText(scheduledTime);
			}
			
		});
		
		timeOfReceiptField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (Order.isCodeValid(productCodeField.getText())) {
				if (leadTimeField.getText().equals("")) {
					contractPriceField.setText("0");
				} else {
					String carName = getCarName();
					getContPrice(carName, leadTimeField.getText());
				}
			} else {
				contractPriceField.setText("0");
			}
			if (!leadTimeField.getText().equals("") && !timeOfReceiptField.getText().equals("")){
				int leadTime = Integer.parseInt(leadTimeField.getText());
				int timeReceipt = Integer.parseInt(timeOfReceiptField.getText());
				String scheduledTime = String.valueOf(leadTime + timeReceipt);
				scheduledDeliveryTimeField.setText(scheduledTime);
			}
			
		});
		

		// add change listener to product code
		productCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (Order.isCodeValid(productCodeField.getText())) {
				String carName = getCarName();

				if (scheduledDeliveryTimeField.getText().length() != 0) {
					getContPrice(carName, scheduledDeliveryTimeField.getText());
				}
			} else {
				chassisField.setText("");
				contractPriceField.setText("0");
			}
		});

		deleteButton.setOnAction(event -> {
			deleteOrder();
		});
		
		

		newButton.setOnAction(event -> {

			addFormButtons(buttonsBox);
			saveFields(currentForm - 1);
			currentForm = formCounter;
			displayValues(currentForm - 1);

		});

	}

	// display this form
	public void display(Button button) throws IOException {

		Parent parent = FXMLLoader.load(getClass().getResource("formB.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();

		scene.getStylesheets().add("forms/Styling.css");
		stage.setScene(scene);
		
		Rectangle2D screen = Screen.getPrimary().getVisualBounds();
		stage.setX(screen.getMinX());
		stage.setY(screen.getMinY());
		stage.setWidth(screen.getWidth());
	
	}

	// extract a car name from a valid product code
	private String getCarName() {
		String carName = "";
		String prodLine = Character.toString(productCodeField.getText().charAt(0));
		String chassis = Character.toString(productCodeField.getText().charAt(1));
		chassis += Character.toString(productCodeField.getText().charAt(2));

		switch (prodLine.toLowerCase()) {
		case "f":
			carName = "Family ";
			break;
		case "P":
		case "p":
			carName = "Pony ";
			break;
		case "S":
		case "s":
			carName = "Sedan ";
			break;
		case "A":
		case "a":
			carName = "Ayrton ";
			break;
		case "C":
		case "c":
			carName = "Coast";
			break;
		case "T":
		case "t":
			carName = "Thunder";
			break;
		}

		switch (chassis.toLowerCase()) {
		case "st":
			chassisField.setText("Standard");
			carName += "Standard";
			break;
		case "dr":
			chassisField.setText("Dragstar");
			carName += "Dragstar";
			break;
		case "de":
			chassisField.setText("Deluxe");
			carName += "Deluxe";
			break;
		case "ss":
			chassisField.setText("Special");
			break;

		}
		return carName;
	}

	// convert time input into a correct integer for a contract price call
	private void getContPrice(String carName, String time) {

		try {
			Double t = Double.parseDouble(leadTimeField.getText());
			int price;

			if (t < 0 || t > 10) {
				price = 0;
			} else if (t < 1) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "1");
			} else if (t < 2) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "2");
			} else if (t < 3) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "3");
			} else if (t < 4) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "4");
			} else if (t < 5) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "5");
			} else if (t < 6) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "6");
			} else if (t < 7) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "7");
			} else if (t < 8) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "8");
			} else if (t < 9) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "9");
			} else {
				price = PSDSingleton.getInstance().getContractPrice(carName, "10");
			}

			if (price != 0) {
				contractPriceField.setText(Integer.toString(price));
			} else {
				contractPriceField.setText("0");
			}

		} catch (Exception e) {
			System.out.println("entered time is not a number");
		}
	}
}
